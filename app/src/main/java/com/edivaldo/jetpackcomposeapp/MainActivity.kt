package com.edivaldo.jetpackcomposeapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
    MyMessage("Hola Jetpack Compose 1", "Are you read 1? Este atributo acepta una lista separada por comas de los ID."),
    MyMessage("Hola Jetpack Compose 2", "Are you read 2? Este atributo acepta una lista separada por comas de los ID de problemas de Lint que quieres que las herramientas omitan en este elemento."),
    MyMessage("Hola Jetpack Compose 3", "Are you read 3? Este atributo acepta una lista separada por comas de los ID de problemas de Lint que quieres que las herramientas omitan en este elemento y en todos los elementos descendientes."),
    MyMessage("Hola Jetpack Compose 4", "Are you read 4? Este atributo acepta una lista separada por comas de los ID de problemas de Lint que quieres que las herramientas omitan en este elemento y en todos los elementos descendientes."),
    MyMessage("Hola Jetpack Compose 5", "Are you read 5? Este atributo acepta una lista separada por comas de los ID de problemas de Lint que quieres que las herramientas omitan en este elemento y en todos los elementos descendientes."),
    MyMessage("Hola Jetpack Compose 6", "Are you read 6? Este atributo acepta una lista separada por comas de los ID de problemas de Lint que quieres que las herramientas omitan en este elemento y en todos los elementos descendientes."),
    MyMessage("Hola Jetpack Compose 7", "Are you read 7? Este atributo acepta una lista separada por comas de los ID de problemas de Lint que quieres que las herramientas omitan en este elemento y en todos los elementos descendientes."),
    MyMessage("Hola Jetpack Compose 8", "Are you read 8? Este atributo acepta una lista separada por comas de los ID de problemas de Lint que quieres que las herramientas omitan en este elemento y en todos los elementos descendientes."),
    MyMessage("Hola Jetpack Compose 9", "Are you read 9? Este atributo acepta una lista separada por comas de los ID de problemas de Lint que quieres que las herramientas omitan en este elemento y en todos los elementos descendientes."),
    MyMessage("Hola Jetpack Compose 10", "Are you read 10? Este atributo acepta una lista separada por comas de los ID de problemas de Lint que quieres que las herramientas omitan en este elemento y en todos los elementos descendientes."),
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
    var expanded by remember { mutableStateOf(false) } // muta el valor para poder mutar y repintar la interfaz

    Column(modifier = Modifier.padding(start = 8.dp).clickable {
        expanded = !expanded
    }) {
        MyText(
            message.title,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(16.dp))// Separate componentes
        MyText(
            message.body,
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2,
            if (expanded) Int.MAX_VALUE else 1 // Cantidad de linea a mostrar
        )
    }
}

@Composable
private fun MyText(text: String, color: Color, style: TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(text, color = color, style = style, maxLines = lines)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewComponent() {
    JetPackComposeAppTheme {
        MyMessages(messages)
    }
}