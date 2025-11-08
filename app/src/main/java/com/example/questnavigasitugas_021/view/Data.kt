package com.example.questnavigasitugas_021.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListData(
    onBackBtnClick : () -> Unit,
    onEnterBtnClick : () -> Unit
){
    val isButtonBackLoading = remember { mutableStateOf(false) }
    val isButtonEnterLoading = remember { mutableStateOf(false) }
    val isDataLoading = remember { mutableStateOf(true) }
    val shimmer = rememberShimmer(
        shimmerBounds = ShimmerBounds.Window,
        theme = com.valentinilk.shimmer.defaultShimmerTheme.copy(
            animationSpec = androidx.compose.animation.core.infiniteRepeatable(
                animation = androidx.compose.animation.core.tween(
                    durationMillis = 600,  // Lebih cepat - dari 1000ms ke 600ms
                    easing = androidx.compose.animation.core.LinearEasing
                ),
                repeatMode = androidx.compose.animation.core.RepeatMode.Restart
            ),
            shaderColors = listOf(
                Color.Gray.copy(alpha = 0.3f),
                Color.LightGray.copy(alpha = 0.5f),
                Color.Gray.copy(alpha = 0.3f)
            ),
            rotation = 15f
        )
    )

    LaunchedEffect(Unit) {
        delay(2000)
        isDataLoading.value = false
    }

    val dataList = listOf(
        FormData(
            nama = "Mananta",
            gender = "Perempuan",
            status = "Belum Menikah",
            alamat = "Tulungagung"
        ),
        FormData(
            nama = "Mananta",
            gender = "Perempuan",
            status = "Belum Menikah",
            alamat = "Tulungagung"
        ),
        FormData(
            nama = "Mananta",
            gender = "Perempuan",
            status = "Belum Menikah",
            alamat = "Tulungagung"
        ),
        FormData(
            nama = "Mananta",
            gender = "Perempuan",
            status = "Belum Menikah",
            alamat = "Tulungagung"
        ),
        FormData(
            nama = "Mananta",
            gender = "Perempuan",
            status = "Belum Menikah",
            alamat = "Tulungagung"
        ),
    )
    Scaffold(Modifier,
        bottomBar = {
        BottomAppBar(
            containerColor = Color.Black) {
            Row(Modifier.padding(all = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Button(
                    onClick = {
                        isButtonBackLoading.value = true
                    },
                    enabled = !isButtonBackLoading.value,
                    modifier = Modifier.weight(1f).padding(end = 5.dp)
                ) {
                    if (isButtonBackLoading.value) {
                        CircularProgressIndicator(
                            modifier = Modifier.height(24.dp).width(24.dp),
                            color = Color.White,
                            strokeWidth = 2.dp
                        )
                    } else {
                        Text("Kembali")
                    }
                }
                Button(
                    onClick = {
                        isButtonEnterLoading.value = true
                    },
                    enabled = !isButtonEnterLoading.value,
                    modifier = Modifier.weight(weight = 1f).padding(start = 5.dp)
                ) {
                    if (isButtonEnterLoading.value) {
                        CircularProgressIndicator(
                            modifier = Modifier.height(24.dp).width(24.dp),
                            color = Color.White,
                            strokeWidth = 2.dp
                        )
                    } else {
                        Text("Daftar")
                    }
                }
                if (isButtonBackLoading.value) {
                    LaunchedEffect(Unit) {
                        delay(1500)
                        onBackBtnClick()
                    }
                }
                if (isButtonEnterLoading.value) {
                    LaunchedEffect(Unit) {
                        delay(1500)
                        onEnterBtnClick()
                    }
                }
            }
        }
    }, topBar = {
        TopAppBar(
            title = {
                Column(modifier = Modifier.padding(start = 109.dp)){
                    Text("List Anggota",
                        color = Color.White,
                        fontFamily = FontFamily.Monospace
                    )
                } },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.Black
            )
        )
    }, containerColor = Color.Black, contentColor = Color.White

        ) { isiRuang ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(isiRuang)
        ){
            if (isDataLoading.value) {
                items(dataList.size) {
                    SkeletonCard(shimmer = shimmer)
                }
            } else{
                items(dataList.size) { index ->
                    val formData = dataList[index]
                    DataCard(formData = formData)
                }
            }
        }
    }

}

@Composable
fun DataCard(formData: FormData) {
    Card(
        modifier = Modifier.padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        ),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f).padding(end = 8.dp)
                ) {
                    Text(
                        text = "NAMA LENGKAP",
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = formData.nama,
                        color = Color.White
                    )
                }
                Column(
                    modifier = Modifier.weight(1f).padding(start = 8.dp)
                ) {
                    Text(
                        text = "JENIS KELAMIN",
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = formData.gender,
                        color = Color.White
                    )
                }
            }
            Row {
                Column(
                    modifier = Modifier.weight(1f).padding(end = 8.dp)
                ) {
                    Text(
                        text = "STATUS PERKAWINAN",
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = formData.status,
                        color = Color.White
                    )
                }
                Column(
                    modifier = Modifier.weight(1f).padding(start = 8.dp)
                ) {
                    Text(
                        text = "ALAMAT",
                        color = Color.Gray,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = formData.alamat,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun SkeletonCard(shimmer: com.valentinilk.shimmer.Shimmer) {
    Card(
        modifier = Modifier.padding(10.dp).shimmer(shimmer),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        ),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .shimmer(shimmer)
        ) {
            Row(
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f).padding(end = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .height(12.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color.Gray.copy(alpha = 0.3f))
                    )
                    Box(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(0.9f)
                            .height(16.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color.Gray.copy(alpha = 0.3f))
                    )
                }
                Column(
                    modifier = Modifier.weight(1f).padding(start = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(12.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color.Gray.copy(alpha = 0.3f))
                    )
                    Box(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(0.7f)
                            .height(16.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color.Gray.copy(alpha = 0.3f))
                    )
                }
            }
            Row {
                Column(
                    modifier = Modifier.weight(1f).padding(end = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(12.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color.Gray.copy(alpha = 0.3f))
                    )
                    Box(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(0.8f)
                            .height(16.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color.Gray.copy(alpha = 0.3f))
                    )
                }
                Column(
                    modifier = Modifier.weight(1f).padding(start = 8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .height(12.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color.Gray.copy(alpha = 0.3f))
                    )
                    Box(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(0.75f)
                            .height(16.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color.Gray.copy(alpha = 0.3f))
                    )
                }
            }
        }
    }
}

data class FormData(
    val nama: String,
    val gender: String,
    val status: String,
    val alamat: String
)

