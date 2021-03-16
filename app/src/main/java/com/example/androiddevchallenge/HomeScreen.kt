package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeScreen() {
    Scaffold {
        Column(
            modifier = Modifier.verticalScroll(
                state = rememberScrollState()
            )
        ) {
            OutlinedTextField(
                value = "Search",
                onValueChange = { /*no action*/ },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null // decorative element
                    )

                }
            )
            Text(text = stringResource(R.string.home_favorite_collections))
            LazyRow() {
                items(favoriteItemsData.subList(0, 3)) {
                    FavItem(data = it)
                }
            }
            LazyRow() {
                items(favoriteItemsData.subList(3, 6)) {
                    FavItem(data = it)
                }
            }
            Section(header = stringResource(R.string.home_body_header), itemsData = bodyItemsData)
            Section(header = stringResource(R.string.home_mind_header), itemsData = mindItemsData)
        }
    }
}

@Composable
fun FavItem(data: Item) {
    Row() {
        Image(painter = painterResource(id = data.image), contentDescription = data.name)
        Text(text = data.name)
    }
}

@Composable
fun Section(header: String, itemsData: List<Item>) {
    Text(text = header)
    LazyRow() {
        items(itemsData) {
            RoundItem(data = it)
        }
    }
}

@Composable
fun RoundItem(data: Item) {
    Column() {
        Image(painter = painterResource(id = data.image), contentDescription = data.name)
        Text(text = data.name)
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightHomePreview() {
    MyTheme {
        HomeScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkHomePreview() {
    MyTheme(darkTheme = true) {
        HomeScreen()
    }
}