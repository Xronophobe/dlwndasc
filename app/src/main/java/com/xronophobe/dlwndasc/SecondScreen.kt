package com.xronophobe.dlwndasc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.xronophobe.dlwndasc.ui.theme.DlwndascTheme

@Composable
fun SecondScreen() {
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
        Text(text="This is the second screen")
    }
}

@Composable
@Preview(showBackground = true)
fun SecondScreenPreview(){
    DlwndascTheme {
        SecondScreen()
    }
}