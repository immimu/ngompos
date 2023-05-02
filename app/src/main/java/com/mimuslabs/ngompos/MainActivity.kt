package com.mimuslabs.ngompos

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mimuslabs.ngompos.R.string
import com.mimuslabs.ngompos.entity.MenuItem
import com.mimuslabs.ngompos.ui.theme.NgomposTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      NgomposTheme {
        ContentMenu { item ->
          handleMenuClick(item)
        }
      }
    }
  }

  private fun handleMenuClick(item: MenuItem) {
    if (item.menuId == 1) {
      startActivity(Intent(this, BasicLayoutActivity::class.java))
    }
  }
}

@Composable
fun ContentMenu(onItemClick: (MenuItem) -> Unit) {
  val listMenu = listOf(
    MenuItem(
      1,
      stringResource(string.title_basic_layout),
      stringResource(string.subtitle_basic_layout)
    ),
    MenuItem(
      1,
      stringResource(string.title_basic_layout),
      stringResource(string.subtitle_basic_layout)
    ),
    MenuItem(
      1,
      stringResource(string.title_basic_layout),
      stringResource(string.subtitle_basic_layout)
    ),
    MenuItem(
      1,
      stringResource(string.title_basic_layout),
      stringResource(string.subtitle_basic_layout)
    ),
    MenuItem(
      1,
      stringResource(string.title_basic_layout),
      stringResource(string.subtitle_basic_layout)
    ),
    MenuItem(
      1,
      stringResource(string.title_basic_layout),
      stringResource(string.subtitle_basic_layout)
    )
  )
  LazyColumn(modifier = Modifier.fillMaxSize()) {
    item {
      Text(
        modifier = Modifier
          .fillMaxWidth()
          .padding(start = 20.dp, end = 20.dp, top = 30.dp),
        text = stringResource(string.text_compose_basic),
        fontSize = 22.sp,
        fontWeight = Companion.Bold
      )
    }
    items(listMenu) { item ->
      MenuItemView(item) {
        onItemClick(item)
      }
    }
  }
}

@Composable
fun MenuItemView(item: MenuItem, onItemClick: () -> Unit) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(start = 20.dp, end = 20.dp, top = 10.dp)
      .clickable { onItemClick() },
    backgroundColor = MaterialTheme.colors.background,
    contentColor = MaterialTheme.colors.onBackground,
    shape = RoundedCornerShape(8.dp),
    elevation = 4.dp
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
      Text(text = item.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
      Text(text = item.subTitle, fontSize = 14.sp)
    }
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  NgomposTheme {
    MenuItemView(
      item = MenuItem(
        1,
        stringResource(string.title_basic_layout),
        stringResource(string.subtitle_basic_layout)
      )
    ) {
      // no opt
    }
  }
}