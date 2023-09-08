package com.example.mvvm.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.mvvm.R
import com.example.mvvm.data.AuthViewModel
import com.example.mvvm.navigation.ROUTE_ADD
import com.example.mvvm.navigation.ROUTE_PIC
import com.example.mvvm.navigation.ROUTE_VIEW
import com.example.mvvm.ui.theme.screens.products.AddProductsScreen

@Composable
fun Homescreen(navController: NavHostController) {

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(243, 253, 232)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "   Welcome To The Homepage ! ",
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight(300),
            color = Color.Black,
            fontSize = 30.sp,
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            {    navController.navigate(ROUTE_ADD) },
            modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(158, 210, 190)
            ),
        ) {
            Text(
                text = "Add product",
                style = TextStyle(letterSpacing = 1.sp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(100),
                fontSize = 28.sp,
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {   navController.navigate(ROUTE_VIEW) },
            modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(158, 210, 190)
            ),
        ) {

            Text(
                text = "View product",
                style = TextStyle(letterSpacing = 1.sp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(100),
                fontSize = 28.sp,
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        Button(
            onClick = { navController.navigate(ROUTE_PIC)},
            modifier = Modifier.width(250.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(158, 210, 190)
            ),
        ) {
            Text(
                text = "Click to see",
                style = TextStyle(letterSpacing = 1.sp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(200),
                fontSize = 28.sp,
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = {
                val mylogout = AuthViewModel(navController, context)
                mylogout.logout()
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(158, 210, 190)
            ),
        ) {
            Text(
                text = "Logout",
                style = TextStyle(letterSpacing = 2.sp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(300),
                fontSize = 25.sp,
            )
        }
        }
}
@Preview
@Composable
fun Homescr() {
    Homescreen(rememberNavController())

}
