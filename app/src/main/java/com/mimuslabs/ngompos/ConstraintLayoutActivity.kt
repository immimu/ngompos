package com.mimuslabs.ngompos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.mimuslabs.ngompos.entity.SettingMenu
import com.mimuslabs.ngompos.ui.theme.NgomposTheme

class ConstraintLayoutActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      NgomposTheme {
        ContentCompose()
      }
    }
  }

  @Composable
  fun ContentCompose() {
    val data = listOf(
      SettingMenu(Icons.Outlined.AccountBox, "Your channel"),
      SettingMenu(Icons.Outlined.Email, "Turn on Incognito"),
      SettingMenu(Icons.Outlined.Add, "Add account"),
      SettingMenu(Icons.Outlined.Add, "Get YouTube Premium"),
      SettingMenu(Icons.Outlined.Settings, "Purchase and memberships"),
      SettingMenu(Icons.Outlined.Search, "Time watched"),
      SettingMenu(Icons.Outlined.Star, "Your data in YouTube"),
      SettingMenu(Icons.Outlined.ShoppingCart, "Settings"),
      SettingMenu(Icons.Outlined.Email, "Help & feedback"),
      SettingMenu(Icons.Outlined.Settings, "YouTube Studio"),
      SettingMenu(Icons.Outlined.Settings, "YouTube Music"),
      SettingMenu(Icons.Outlined.Settings, "YouTube Kids")
    )

    LazyColumn {

      itemsIndexed(data) { index, item ->
        SettingItem(modifier = Modifier.padding(start = 20.dp, end = 20.dp), settingMenu = item)

        if (index == 2 || index == 6 || index == 8) {
          Divider(modifier = Modifier.fillMaxWidth(), thickness = 1.dp, color = Color.Black)
        }
      }
    }
  }

  @Composable
  fun SettingItem(modifier: Modifier = Modifier, settingMenu: SettingMenu) {
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
      val (icon, title) = createRefs()
      Icon(
        imageVector = settingMenu.imageVector,
        contentDescription = "Click button setting",
        modifier = Modifier
          .padding(end = 16.dp, top = 16.dp, bottom = 16.dp)
          .constrainAs(icon) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
          }
      )
      Text(
        text = settingMenu.title, color = Color.Black, fontSize = 16.sp,
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 16.dp, bottom = 16.dp)
          .constrainAs(title) {
            start.linkTo(icon.end, margin = 10.dp)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
          }
      )
    }
  }
}