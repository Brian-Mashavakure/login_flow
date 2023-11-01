package com.login_flow.app.components

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.login_flow.R
import com.login_flow.ui.theme.ClickableTextColor
import com.login_flow.ui.theme.PrimaryColor
import com.login_flow.ui.theme.TextColor


@Composable
fun NormalTextComponent(
    value : String
){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 30.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
        ),
        color = TextColor,
        textAlign = TextAlign.Center,
    )
}


@Composable
fun HeaderTextComponent(
    value : String
){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
        ),
        color = TextColor,
        textAlign = TextAlign.Center,
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    labelValue: String,
    painterResource: Painter,
    iconDescription: String,
){
    var textValue by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8)),
        label = { Text(text = labelValue) },
        value = textValue,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = PrimaryColor,
            focusedLabelColor = PrimaryColor,
            cursorColor = PrimaryColor,
        ),
        keyboardOptions = KeyboardOptions.Default,
        onValueChange = { textValue = it },
        leadingIcon = { Icon(painterResource, contentDescription = iconDescription)}
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    labelValue: String,
    iconResource: Painter,
    iconDescription: String,
){
    var passwordValue by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf( false ) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8)),
        label = { Text(text = labelValue) },
        value = passwordValue,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = PrimaryColor,
            focusedLabelColor = PrimaryColor,
            cursorColor = PrimaryColor,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = { passwordValue = it },
        leadingIcon = { Icon(iconResource, contentDescription = iconDescription)},
        trailingIcon = {

            var iconImage = if(passwordVisible){
                painterResource(id = R.drawable.visibility)
            }else{
                painterResource(id = R.drawable.visibility_off)
            }
            
            var description = if(passwordVisible){
                "Hide Password"
            }else{
                "Show Password"
            }
            
            IconButton(
                onClick = { passwordVisible = !passwordVisible }
            ) {
                Icon(iconImage, contentDescription = description)
            }


        },
        visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
    )
}

@Composable
fun CheckBoxComponent(
    value: String,
    onTextSelected: (String) -> Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        val checkedState by remember { mutableStateOf<Boolean>(false) }

        Checkbox(checked = checkedState, onCheckedChange = { checkedState != checkedState})
        
        ClickableTextComponent(value = value, onTextSelected)
    }
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit){
    val initialText = stringResource(id = R.string.initial_text)
    val privacyText = stringResource(id = R.string.privacy)
    val andText = " and "
    val termsText = stringResource(id = R.string.terms)

    val annotatedString = buildAnnotatedString {
        append(initialText)

        withStyle(
            style = SpanStyle(color = ClickableTextColor)
        ){
            pushStringAnnotation(tag = privacyText, annotation = privacyText)
            append(privacyText)
        }

        append(andText)

        withStyle(
            style = SpanStyle(color = ClickableTextColor)
        ){
            pushStringAnnotation(tag = termsText, annotation = termsText)
            append(termsText)
        }

    }

    ClickableText(
        text = annotatedString,
        onClick = {
            offset -> annotatedString.getStringAnnotations(
                offset, offset
            ).firstOrNull()?.also{ span ->
                Log.d("ClickableTextComponent", "${span.item}")

                if((span.item == termsText) || (span.item == privacyText)){
                    onTextSelected(span.item)
                }


        }
        }
    )
}