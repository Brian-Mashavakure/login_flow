package com.login_flow.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.login_flow.app.navigation.PostOfficeAppRouter
import com.login_flow.app.navigation.Screen
import com.login_flow.app.screens.Login
import com.login_flow.app.screens.SignUp
import com.login_flow.app.screens.TermsAndConditions
import com.login_flow.ui.theme.Gray

@Composable
fun PostOfficeApp(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ){
        Crossfade(targetState = PostOfficeAppRouter.currentScreen) {
            currentState -> when(currentState.value){
                is Screen.SignUp-> {
                    SignUp()
                }
                is Screen.TermsAndConditions -> {
                    TermsAndConditions()
                }

                is Screen.Login -> {
                    Login()
                }
            }

        }
    }
}
