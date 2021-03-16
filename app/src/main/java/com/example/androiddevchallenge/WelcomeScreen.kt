package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.MyButton
import com.example.androiddevchallenge.ui.screenContentPaddingModifier
import com.example.androiddevchallenge.ui.spaceLarge
import com.example.androiddevchallenge.ui.spaceSmall
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomeScreen(navController: NavHostController? = null) {
    Surface(color = MaterialTheme.colors.background) {
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = if (MaterialTheme.colors.isLight) R.drawable.ic_light_welcome else R.drawable.ic_dark_welcome),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = screenContentPaddingModifier
            ) {
                Image(
                    painter = painterResource(id = if (MaterialTheme.colors.isLight) R.drawable.ic_light_logo else R.drawable.ic_dark_logo),
                    contentDescription = null,
                    modifier = Modifier.padding(bottom = spaceLarge)
                )
                MyButton(
                    text = stringResource(R.string.welcome_sign_up),
                    modifier = Modifier.padding(bottom = spaceSmall)
                )
                MyButton(
                    text = stringResource(R.string.welcome_lon_in),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                ) { navController?.navigate(SCREEN_LOGIN) }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightWelcomePreview() {
    MyTheme {
        WelcomeScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkWelcomePreview() {
    MyTheme(darkTheme = true) {
        WelcomeScreen()
    }
}