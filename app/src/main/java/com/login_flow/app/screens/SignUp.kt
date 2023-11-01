package com.login_flow.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.login_flow.R
import com.login_flow.app.components.CheckBoxComponent
import com.login_flow.app.components.CustomTextField
import com.login_flow.app.components.HeaderTextComponent
import com.login_flow.app.components.NormalTextComponent
import com.login_flow.app.components.PasswordTextField
import com.login_flow.app.navigation.PostOfficeAppRouter
import com.login_flow.app.navigation.Screen
import com.login_flow.ui.theme.Gray

@Composable
fun SignUp(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp)
        ){

            NormalTextComponent(value = stringResource(id = R.string.hello))

            HeaderTextComponent(value = stringResource(id = R.string.create_account))

            Spacer(modifier = Modifier.height(15.dp))
            
            CustomTextField(
                labelValue = stringResource(id = R.string.firstname),
                painterResource = painterResource(id = R.drawable.profile),
                iconDescription = "profile icon"
            )

            Spacer(modifier = Modifier.height(5.dp))

            CustomTextField(
                labelValue = stringResource(id = R.string.lastname),
                painterResource = painterResource(id = R.drawable.profile),
                iconDescription = "profile icon"
            )

            Spacer(modifier = Modifier.height(5.dp))

            CustomTextField(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(id = R.drawable.email),
                iconDescription = "mail icon"
            )

            Spacer(modifier = Modifier.height(5.dp))

            PasswordTextField(
                labelValue = stringResource(id = R.string.password),
                iconResource = painterResource(id = R.drawable.password),
                iconDescription = "padlock icon,"
            )

            Spacer(modifier = Modifier.height(5.dp))
            
            CheckBoxComponent(
                value = stringResource(id = R.string.terms_and_conditions),
                onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.TermsAndConditions)
                }
                )


        }
    }
}

//Preview annotation used to see screen preview in split mode
@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUp()
}
