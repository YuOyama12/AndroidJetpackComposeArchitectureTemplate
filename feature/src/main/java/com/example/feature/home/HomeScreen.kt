package com.example.feature.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navToSub: () -> Unit
) {
    Button(
        modifier = Modifier.padding(8.dp),
        onClick = { navToSub() }
    ) {
        Text(text = "サブ画面へ遷移")
    }
}