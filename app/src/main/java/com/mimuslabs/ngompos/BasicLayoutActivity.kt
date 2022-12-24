package com.mimuslabs.ngompos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mimuslabs.ngompos.ui.theme.NgomposTheme

class BasicLayoutActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      NgomposTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          Column {
            BasicLayoutColumn()
            BasicLayoutRow()
          }
        }
      }
    }
  }
}

@Composable
fun BasicLayoutColumn() {
  Column(
    modifier = Modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = "Baris 1")
    Text(text = "Baris 2")
    Text(text = "Baris 3")
    Text(text = "Baris 4")
    Text(text = "Baris 5")
  }
}

@Composable
fun BasicLayoutRow() {
  Row {
    Text(text = "Baris 1")
    Text(text = "Baris 2")
    Text(text = "Baris 3")
    Text(text = "Baris 4")
    Text(text = "Baris 5")
  }
}

@Preview(showBackground = true)
@Composable
fun PreviewBasicLayout() {
  Column {
    BasicLayoutColumn()
    BasicLayoutRow()
  }
}
