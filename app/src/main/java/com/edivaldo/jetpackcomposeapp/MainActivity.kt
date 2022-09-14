package com.edivaldo.jetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edivaldo.jetpackcomposeapp.ui.theme.JetPackComposeAppTheme
import java.security.PrivateKey

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComponent()
        }
    }
}

@Composable
fun MyComponent() {
    Row(modifier = Modifier.padding(8.dp)) {
        MyImage()
        MyTexts()
    }
}

@Composable
private fun MyImage() {
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        contentDescription="Es una imagen"
    )
}

@Composable
private fun MyTexts(){
    Column(modifier = Modifier.padding(start=8.dp)) {
        MyText(text = "Hola Ject Compose !")
        Spacer(modifier = Modifier.height(16.dp))
        MyText(text = "¿Preparado?")
    }
}

@Composable
private fun MyText(text: String){
    Text(text)
}

@Preview
@Composable
private fun PreviewComponent() {
    MyComponent()
}