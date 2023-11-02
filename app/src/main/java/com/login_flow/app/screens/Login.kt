package com.login_flow.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import com.login_flow.app.components.ButtonComponent
import com.login_flow.app.components.ClickableLoginTextComponent
import com.login_flow.app.components.CustomTextField
import com.login_flow.app.components.DividerTextComponent
import com.login_flow.app.components.HeaderTextComponent
import com.login_flow.app.components.NormalTextComponent
import com.login_flow.app.components.PasswordTextField
import com.login_flow.app.components.UnderlinedTextComponent
import com.login_flow.app.navigation.PostOfficeAppRouter
import com.login_flow.app.navigation.Screen
import com.login_flow.app.navigation.SystemBackButtonHandler

@Composable
fun Login(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            verticalArrangement = Arrangement.Center,
        ){
            NormalTextComponent(value = stringResource(id = R.string.hello))

            HeaderTextComponent(value = stringResource(id = R.string.welcome))

            Spacer(modifier = Modifier.height(15.dp))
            
            CustomTextField(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(id = R.drawable.email),
                iconDescription = "Email icon"
            )
            
            Spacer(modifier = Modifier.height(5.dp))

            PasswordTextField(
                labelValue = stringResource(id = R.string.password),
                iconResource = painterResource(id = R.drawable.password),
                iconDescription = "Password icon"
            )

            Spacer(modifier = Modifier.height(10.dp))
            
            UnderlinedTextComponent(value = stringResource(id = R.string.forgot_password))

            Spacer(modifier = Modifier.height(35.dp))


            ButtonComponent(value = stringResource(id = R.string.login))

            Spacer(modifier = Modifier.height(20.dp))

            DividerTextComponent()

            Spacer(modifier = Modifier.height(10.dp))

            ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                PostOfficeAppRouter.navigateTo(Screen.SignUp)
            })


        }

    }

    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.SignUp)
    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    Login()
}