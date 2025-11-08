package com.example.questnavigasitugas_021.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaftarAnggota(
    onSubmitBtnClick: () -> Unit,
    onBackBtnClick: () -> Unit
){
    var txtNama by remember { mutableStateOf("") }
    var txtJk by remember { mutableStateOf("") }
    var txtStatus by remember { mutableStateOf("") }
    var txtAlamat by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var jk by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    var submitted by remember { mutableStateOf(false) }
    var expandedStatus by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    val statusList = listOf("Menikah", "Belum Menikah","Cerai")
    val gender = listOf("Laki-Laki", "Perempuan")

    val isValid = txtNama.isNotEmpty()
            && txtAlamat.isNotEmpty()
            && txtJk.isNotEmpty()
            && txtStatus.isNotEmpty()

    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.Black),

        ) {
        Column(
            Modifier.padding(top = 100.dp).align(Alignment.TopCenter),
        ) {
            Text(
                "Form Registrasi",
                color = Color.White,
                fontFamily = FontFamily.Monospace,
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(Modifier.height(90.dp))
            ElevatedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent,

                    ),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally)
                    .clip(shape = RoundedCornerShape(20.dp)),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 100.dp,
                    pressedElevation = 100.dp,
                    hoveredElevation = 100.dp
                )
            ) {
                Surface(
                    modifier = Modifier.fillMaxWidth(1f).align(Alignment.CenterHorizontally),
                    color = Color.Transparent,
                    border = BorderStroke(0.6.dp, Color.LightGray),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(all = 10.dp)
                            .align(Alignment.CenterHorizontally),
                    ) {
                        Text("Nama Lengkap",
                            color = Color.Gray,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 10.dp, start = 5.dp)
                        )
                        Spacer(Modifier.height(20.dp))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(1f).padding(all = 5.dp),
                            value = txtNama,
                            onValueChange = {txtNama = it},
//                            label = { Text("Nama") },
                            shape = RoundedCornerShape(20.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.LightGray,
                                unfocusedBorderColor = Color.Gray,
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.Gray

                            )
                        )
                        Spacer(Modifier.height(20.dp))
                        Text("Jenis Kelamin",
                            color = Color.Gray,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            gender.forEach { item->
                                RadioButton(
                                    enabled = true,
                                    selected = txtJk == item,
                                    onClick = { txtJk = item },
                                    colors = RadioButtonColors(
                                        selectedColor = Color.White,
                                        unselectedColor = Color.DarkGray,
                                        disabledSelectedColor = Color.White,
                                        disabledUnselectedColor = Color.DarkGray
                                    )
                                )
                                Text(item, color = Color.White)
                            }
                        }
                        Spacer(Modifier.height(20.dp))
                        Text("Status Perkawinan",
                            color = Color.Gray,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                        Spacer(Modifier.height(20.dp))
                        ExposedDropdownMenuBox(
                            expanded = expandedStatus,
                            onExpandedChange = { expandedStatus = !expandedStatus },
                            modifier = Modifier.fillMaxWidth().padding(all = 5.dp)
                        ) {
                            OutlinedTextField(
                                value = txtStatus,
                                onValueChange = {},
                                readOnly = true,
                                placeholder = { Text("Pilih Status Perkawinan") },
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedStatus)
                                },
                                modifier = Modifier
                                    .menuAnchor(androidx.compose.material3.MenuAnchorType.PrimaryNotEditable)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(20.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = Color.LightGray,
                                    unfocusedBorderColor = Color.Gray,
                                    focusedContainerColor = Color.White,
                                    unfocusedContainerColor = Color.Gray,
                                    focusedTextColor = Color.Black,
                                    unfocusedTextColor = Color.Black
                                )
                            )
                            ExposedDropdownMenu(
                                expanded = expandedStatus,
                                onDismissRequest = { expandedStatus = false },
                                modifier = Modifier.background(Color.White)
                            ) {
                                statusList.forEach { item ->
                                    DropdownMenuItem(
                                        text = { Text(item, color = Color.Black) },
                                        onClick = {
                                            txtStatus = item
                                            expandedStatus = false
                                        }
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.height(20.dp))
                        Text("Alamat",
                            color = Color.Gray,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                        Spacer(Modifier.height(20.dp))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(1f).padding(all = 5.dp),
                            value = txtAlamat,
                            onValueChange = {txtAlamat = it},
                            shape = RoundedCornerShape(20.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.LightGray,
                                unfocusedBorderColor = Color.Gray,
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.Gray
                            )
                        )
                        Spacer(Modifier.height(20.dp))
                        Spacer(Modifier.height(70.dp))
                        Row(Modifier.fillMaxWidth().padding(all = 5.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Button(
                                modifier = Modifier.width(150.dp),
                                onClick = onBackBtnClick,

                                ) {
                                Text("Kembali")

                            }
                            Spacer(Modifier.width(10.dp))
                            Button(
                                enabled = isValid ,
                                modifier = Modifier.width(150.dp),
                                onClick = {
                                    showDialog = true
                                },
                                colors = ButtonDefaults.buttonColors(
                                    disabledContainerColor = Color.LightGray,
                                    disabledContentColor = Color.Black
                                )
                            ) {
                                Text("Submit")

                            }
                        }
                    }
                }

            }


        }


        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = {
                    Text(
                        text = "Konfirmasi Data",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                text = {
                    Column {
                        Text("Pastikan data Anda sudah benar:", fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(16.dp))
                        Text("Nama: $txtNama")
                        Spacer(Modifier.height(8.dp))
                        Text("Jenis Kelamin: $txtJk")
                        Spacer(Modifier.height(8.dp))
                        Text("Status: $txtStatus")
                        Spacer(Modifier.height(8.dp))
                        Text("Alamat: $txtAlamat")
                    }
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showDialog = false
                            onSubmitBtnClick()
                        }
                    ) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showDialog = false }
                    ) {
                        Text("Batal")
                    }
                }
            )
        }


    }


}