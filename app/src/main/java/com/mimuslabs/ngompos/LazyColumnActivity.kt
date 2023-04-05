package com.mimuslabs.ngompos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mimuslabs.ngompos.ui.theme.NgomposTheme

class LazyColumnActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      NgomposTheme {
      }
      ContentCompose()
    }
  }
}

@Composable
fun ContentCompose() {
  val data = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8")

  LazyColumn {
    item {
      Text(
        text = "Ini Header",
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
      )
    }
    item {
      Text(
        text = "item 0", modifier = Modifier
          .fillMaxWidth()
          .padding(start = 16.dp, end = 16.dp, bottom = 16.dp), fontSize = 16.sp
      )
    }

    items(data) { item ->
      Text(
        text = item, modifier = Modifier
          .fillMaxWidth()
          .padding(start = 16.dp, end = 16.dp, bottom = 16.dp), fontSize = 16.sp
      )
    }
  }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun PrevContentCompose() {
  ContentCompose()
}