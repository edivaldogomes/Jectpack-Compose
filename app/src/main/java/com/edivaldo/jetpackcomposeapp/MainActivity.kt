package com.edivaldo.jetpackcomposeapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edivaldo.jetpackcomposeapp.ui.theme.JetPackComposeAppTheme
import java.security.PrivateKey

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeAppTheme() {
                MyComponent()
            }
        }
    }
}

@Composable
fun MyComponent() {
    Row(modifier = Modifier
        .padding(8.dp)
        .background(MaterialTheme.colors.background)) {
        MyImage()
        MyTexts()
    }
}

@Composable
private fun MyImage() {
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Es una imagen",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
            .size(64.dp)
    )
}

@Composable
private fun MyTexts() {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText(text = "Hola Ject Compose !",
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1
            )
        Spacer(modifier = Modifier.height(16.dp))// Separate componentes
        MyText(text = "¿Preparado?",
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2
            )
    }
}

@Composable
private fun MyText(text: String, color: Color, style: TextStyle) {
    Text(text, color = color, style = style)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewComponent() {
    JetPackComposeAppTheme {
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
        }
    }
}