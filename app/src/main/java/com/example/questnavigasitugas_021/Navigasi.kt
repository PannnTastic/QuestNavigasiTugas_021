package com.example.questnavigasitugas_021


import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasitugas_021.view.DaftarAnggota
import com.example.questnavigasitugas_021.view.ListData
import com.example.questnavigasitugas_021.view.WelcomePage
import com.valentinilk.shimmer.shimmer


enum class Navigasi{
    Welcome,
    Data,
    Daftar
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier
){
    Box(){
        NavHost(
            navController = navController,
            startDestination = Navigasi.Welcome.name,

            modifier = Modifier.padding().fillMaxSize()
        ){
            composable(route = Navigasi.Welcome.name) {
                WelcomePage(
                    enterBtnClick = {
                        navController.navigate(route = Navigasi.Data.name)
                    }
                )
            }
            composable(route = Navigasi.Data.name){
                ListData(
                    onBackBtnClick = {cancelAndBackToWelcome(navController)},
                    onEnterBtnClick = {
                        navController.navigate(route = Navigasi.Daftar.name)
                        nextToForm(navController)
                    }
                )
            }
            composable(route = Navigasi.Daftar.name) {
                DaftarAnggota(
                    onSubmitBtnClick = {cancelAndBackToList(navController)},
                    onBackBtnClick = {cancelAndBackToList(navController)}
                )
            }
        }
    }

}

