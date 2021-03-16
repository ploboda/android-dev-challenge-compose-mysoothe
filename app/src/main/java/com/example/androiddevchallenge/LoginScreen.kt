package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.ui.MyButton
import com.example.androiddevchallenge.ui.MyTextField
import com.example.androiddevchallenge.ui.screenContentPaddingModifier
import com.example.androiddevchallenge.ui.spaceLarge
import com.example.androiddevchallenge.ui.spaceSmall
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun LoginScreen(navController: NavHostController? = null) {
    Surface(color = MaterialTheme.colors.background) {
        Box(contentAlignment = Alignment.TopCenter) {
            Image(
                painter = painterResource(id = if (MaterialTheme.colors.isLight) R.drawable.ic_light_login else R.drawable.ic_dark_login),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = screenContentPaddingModifier
            ) {
                Text(
                    text = stringResource(R.string.login_header),
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.paddingFromBaseline(top = 200.dp, bottom = spaceLarge)
                )
                MyTextField(
                    placeholder = stringResource(R.string.login_email_address),
                    modifier = Modifier.padding(bottom = spaceSmall)
                )
                MyTextField(
                    placeholder = stringResource(R.string.login_password),
                    modifier = Modifier.padding(bottom = spaceSmall)
                )
                MyButton(text = stringResource(R.string.login_button)) {
                    navController?.navigate(SCREEN_HOME)
                }
                ClickableText(
                    text = buildAnnotatedString {
                        append(stringResource(R.string.login_no_account_phrase))
                        append(" ")
                        withStyle(
                            style = SpanStyle(
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append(stringResource(R.string.login_no_account_button))
                        }
                    },
                    modifier = Modifier.paddingFromBaseline(top = spaceLarge)
                ) {
                    /*no action*/
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightLoginPreview() {
    MyTheme {
        LoginScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkLoginPreview() {
    MyTheme(darkTheme = true) {
        LoginScreen()
    }
}