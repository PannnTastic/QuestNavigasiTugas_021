package com.example.questnavigasitugas_021.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questnavigasitugas_021.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomePage(
    enterBtnClick : () -> Unit
){
    val isButtonLoading = remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black)
    ){
        Column(modifier = Modifier
            .padding(top = 100.dp)
            .align(Alignment.TopCenter)
            , horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Selamat Datang",
                color = Color.White,
                fontSize = 25.sp,
                fontFamily = FontFamily.Monospace
            )
            Spacer(Modifier.height(100.dp))
            val luffy = painterResource(id = R.drawable.luffy)
            Image(
                painter = luffy,
                contentDescription = "luffy",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clip(CircleShape),
//                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(100.dp))
            Column(modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Ahmad Alfan Alfian Irfan",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Monospace
                )
                Text("20230140021",
                    color = Color.White,
                    fontFamily = FontFamily.Monospace,
                )
            }
            Spacer(modifier = Modifier.height(100.dp))
            Button(
                onClick = {
                    isButtonLoading.value = true
                },
                enabled = !isButtonLoading.value,
                modifier = Modifier.width(300.dp).height(50.dp)
            ) {
                if (isButtonLoading.value) {
                    CircularProgressIndicator(
                        modifier = Modifier.height(24.dp).width(24.dp),
                        color = Color.White,
                        strokeWidth = 2.dp
                    )
                } else {
                    Text("Masuk")
                }
            }

            if (isButtonLoading.value) {
                LaunchedEffect(Unit) {
                    delay(1500)
                    enterBtnClick()
                }
            }
        }
    }
}