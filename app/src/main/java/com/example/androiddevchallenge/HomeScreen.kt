package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.MyTextField
import com.example.androiddevchallenge.ui.spaceMedium
import com.example.androiddevchallenge.ui.spaceSmall
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.imePadding
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            MyBottomNavigation()
        },
        floatingActionButton = {
            MyFloatingActionButton()
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        modifier = Modifier.navigationBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(
                    state = rememberScrollState()
                )
                .imePadding()
        ) {
            SearchField()
            FavSection()
            Section(
                headerTest = stringResource(R.string.home_body_header),
                itemsData = bodyItemsData
            )
            Section(
                headerTest = stringResource(R.string.home_mind_header),
                itemsData = mindItemsData
            )
        }
    }
}

@Composable
private fun SearchField() {
    MyTextField(
        placeholder = stringResource(R.string.home_search),
        modifier = Modifier.padding(top = 56.dp, start = spaceMedium, end = spaceMedium)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null, // decorative element
            modifier = Modifier.size(18.dp)
        )
    }
}

@Composable
private fun MyFloatingActionButton() {
    FloatingActionButton(
        shape = CircleShape,
        onClick = { /* no action */ },
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(
            imageVector = Icons.Filled.PlayArrow,
            contentDescription = null
        )
    }
}

@Composable
private fun MyBottomNavigation() {
    BottomNavigation(backgroundColor = MaterialTheme.colors.background) {
        MyBottomNavigationItem(
            selected = true,
            icon = Icons.Filled.Spa,
            text = stringResource(R.string.home_navigation_home)
        )
        MyBottomNavigationItem(
            selected = false,
            icon = Icons.Filled.AccountCircle,
            text = stringResource(R.string.home_navigation_profile)
        )
    }
}

@Composable
fun FavSection() {
    Header(
        text = stringResource(R.string.home_favorite_collections),
        modifier = Modifier.paddingFromBaseline(top = 40.dp, bottom = spaceSmall),
    )
    LazyRow(
        contentPadding = PaddingValues(horizontal = spaceMedium, vertical = 0.dp),
        horizontalArrangement = Arrangement.spacedBy(spaceSmall)
    ) {
        items(3) {
            Column {
                FavItem(data = favoriteItemsData[it])
                Spacer(modifier = Modifier.height(spaceSmall))
                FavItem(data = favoriteItemsData[it + 3])
            }

        }
    }
}

@Composable
fun Header(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier.padding(start = spaceMedium, end = spaceMedium),
        style = MaterialTheme.typography.h2,
    )
}

@Composable
fun FavItem(data: Item) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.size(width = 192.dp, height = 56.dp),
        color = MaterialTheme.colors.surface
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = data.image),
                contentDescription = data.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
            )
            Text(
                text = data.name,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(start = spaceMedium, end = spaceSmall)
            )
        }
    }
}


@Composable
fun Section(headerTest: String, itemsData: List<Item>) {
    Header(
        text = headerTest,
        modifier = Modifier.paddingFromBaseline(top = 48.dp, bottom = spaceSmall)
    )
    LazyRow(
        contentPadding = PaddingValues(horizontal = spaceMedium, vertical = 0.dp),
        horizontalArrangement = Arrangement.spacedBy(spaceSmall)
    ) {
        items(itemsData) {
            RoundItem(data = it)
        }
    }
}

@Composable
fun RoundItem(data: Item) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = data.image), contentDescription = data.name,
            modifier = Modifier
                .height(88.dp)
                .aspectRatio(1f)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = data.name,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.paddingFromBaseline(top = 24.dp)
        )
    }
}

@Composable
fun RowScope.MyBottomNavigationItem(selected: Boolean, icon: ImageVector, text: String) {
    BottomNavigationItem(
        selected = selected,
        onClick = {/*no action*/ },
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
        },
        label = { Text(text, style = MaterialTheme.typography.caption) }
    )
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