package com.edivaldo.jetpackcomposeapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

private val messages: List<MyMessage> = listOf(
    MyMessage("Hola Jetpack Compose 1", "Are you read?"),
    MyMessage("Hola Jetpack Compose 2", "Are you read?"),
    MyMessage("Hola Jetpack Compose 3", "Are you read?"),
    MyMessage("Hola Jetpack Compose 4", "Are you read?"),
    MyMessage("Hola Jetpack Compose 5", "Are you read?"),
    MyMessage("Hola Jetpack Compose 6", "Are you read?"),
    MyMessage("Hola Jetpack Compose 7", "Are you read?"),
    MyMessage("Hola Jetpack Compose 8", "Are you read?"),
    MyMessage("Hola Jetpack Compose 9", "Are you read?"),
    MyMessage("Hola Jetpack Compose 10", "Are you read?"),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeAppTheme() {
                MyMessages(messages)
            }
        }
    }
}

data class MyMessage(val title: String, val body: String)


@Composable
private fun MyMessages(messages: List<MyMessage>) {
    LazyColumn {
        items(messages) { message ->
            MyComponent(message)
        }
    }
}

@Composable
fun MyComponent(message: MyMessage) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .background(MaterialTheme.colors.background)
    ) {
        MyImage()
        MyTexts(message)
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
private fun MyTexts(message: MyMessage) {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        MyText(
            message.title,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(16.dp))// Separate componentes
        MyText(
            message.body,
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
        MyMessages(messages)
    }
}