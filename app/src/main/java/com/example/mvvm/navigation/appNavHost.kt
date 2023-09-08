package com.example.mvvm.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.ui.theme.screens.home.Homescreen
import com.example.mvvm.ui.theme.screens.login.LoginScreen
import com.example.mvvm.ui.theme.screens.products.AddProductsScreen
import com.example.mvvm.ui.theme.screens.products.UpdateProductsScreen
import com.example.mvvm.ui.theme.screens.products.ViewProductsScreen
import com.example.mvvm.ui.theme.screens.redirectlogo.PictureScreen
import com.example.mvvm.ui.theme.screens.register.RegisterScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(modifier: Modifier= Modifier, navController:NavHostController= rememberNavController(), startDestination:String= ROUTE_LOGIN){
    NavHost(navController =navController,modifier=modifier, startDestination = startDestination ){
        composable(ROUTE_HOME){
            Homescreen(navController)
        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
        composable(ROUTE_PIC){
            PictureScreen(navController)
        }
        composable(ROUTE_ADD){
            AddProductsScreen(navController)
        }
        composable(ROUTE_VIEW){
            ViewProductsScreen(navController)
        }
        composable(ROUTE_UPDATE+ "/{id}"){passedData->
          UpdateProductsScreen(navController,passedData.arguments?.getString("id")!!)
        }
    }

}