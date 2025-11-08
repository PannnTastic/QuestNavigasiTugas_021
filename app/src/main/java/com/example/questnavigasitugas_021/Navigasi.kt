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
