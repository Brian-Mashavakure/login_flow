package com.login_flow.app.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.login_flow.app.screens.SignUp
import com.login_flow.app.screens.TermsAndConditions


sealed class Screen(){
    object SignUp: Screen()
    object TermsAndConditions: Screen()

}

object PostOfficeAppRouter{
    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignUp)

    fun navigateTo(destination: Screen){
        currentScreen.value = destination
    }
}