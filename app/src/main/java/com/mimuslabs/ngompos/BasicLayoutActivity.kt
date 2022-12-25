package com.mimuslabs.ngompos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mimuslabs.ngompos.R.string
import com.mimuslabs.ngompos.ui.theme.NgomposTheme

class BasicLayoutActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      NgomposTheme {
        Scaffold(topBar = {
          TopAppBar(navigationIcon = {
            Icon(
              imageVector = Icons.Rounded.Create, contentDescription = null,
              modifier = Modifier.padding(horizontal = 12.dp)
            )
          }, title = {
            Text(text = stringResource(id = string.app_name))
          }, backgroundColor = MaterialTheme.colors.primarySurface)
        }) {
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
}

@Composable
fun BasicLayoutColumn() {
  Column(
    modifier = Modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = "Baris 1", style = MaterialTheme.typography.h5)
    Text(text = "Baris 2", style = MaterialTheme.typography.h4)
    Text(text = "Baris 3", style = MaterialTheme.typography.h3)
    Text(text = "Baris 4", style = MaterialTheme.typography.h2)
    Text(text = "Baris 5", style = MaterialTheme.typography.h1)
  }
}

@Composable
fun BasicLayoutRow() {
  Row {
    Text(text = "Baris 1", style = MaterialTheme.typography.body1)
    Text(text = "Baris 2")
    Text(text = "Baris 3")
    Text(text = "Baris 4")
    Text(text = "Baris 5")
    Text(text = "Baris 6")
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBasicLayout() {
  Column {
    BasicLayoutColumn()
    BasicLayoutRow()
  }
}
