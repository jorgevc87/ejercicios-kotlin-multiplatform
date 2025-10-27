package com.android.ios.cursokmp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cursokmp.composeapp.generated.resources.Res
import cursokmp.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    CustomInit()
}

@Composable
fun Customtext(modifier: Modifier, text: String, fontSize: TextUnit) {
    Text(
        modifier = modifier,
        text = text,
        color = Color.Green,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold
    )
}


@Composable
fun CustomInit() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            Row(
                modifier = Modifier.wrapContentSize().background(Color.Red),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Image(
                    modifier = Modifier.width(30.dp),
                    painter = painterResource(resource = Res.drawable.compose_multiplatform),
                    contentDescription = ""
                )
                Customtext(
                    modifier = Modifier.wrapContentSize().background(Color.Gray),
                    text = "Hola ",
                    fontSize = 24.sp
                )
                Customtext(
                    modifier = Modifier.wrapContentSize().background(Color.Gray),
                    text = "Hola ",
                    fontSize = 24.sp
                )
                Customtext(
                    modifier = Modifier.wrapContentSize().background(Color.Gray),
                    text = "Hola ",
                    fontSize = 24.sp
                )
                Customtext(
                    modifier = Modifier.wrapContentSize().background(Color.Gray),
                    text = "Hola ",
                    fontSize = 24.sp
                )
                Customtext(
                    modifier = Modifier.wrapContentSize().background(Color.Gray),
                    text = "Hola ",
                    fontSize = 24.sp
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun customPreview() {
    CustomInit()
}

