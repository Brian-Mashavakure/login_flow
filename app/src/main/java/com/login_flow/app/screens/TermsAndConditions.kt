package com.login_flow.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.login_flow.R
import com.login_flow.app.components.HeaderTextComponent
import com.login_flow.app.components.NormalTextComponent
import com.login_flow.app.navigation.PostOfficeAppRouter
import com.login_flow.app.navigation.Screen
import com.login_flow.app.navigation.SystemBackButtonHandler

@Composable
fun TermsAndConditions(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ){
        HeaderTextComponent(
                value = stringResource(id = R.string.terms)
        )

    }

    SystemBackButtonHandler {
        PostOfficeAppRouter.navigateTo(Screen.SignUp)
    }
}
