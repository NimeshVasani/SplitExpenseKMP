package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun HomeScreen(modifier: Modifier = Modifier,navController: NavController) {
    Column {
        Box(modifier = Modifier.fillMaxSize().weight(1f).background(color = Color.Red))
        Box(modifier = Modifier.fillMaxSize().weight(1f).background(color = Color.Yellow))
    }
}