package com.example.mvvm.ui.theme.screens.products

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.data.productviewmodel
import com.example.mvvm.models.Product
import com.example.mvvm.navigation.ROUTE_UPDATE




@Composable
fun ViewProductsScreen(navController:NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(243, 253, 232)),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var productRepository = productviewmodel(navController, context)
        val emptyProductState = remember { mutableStateOf(Product("","","","")) }
        var emptyProductsListState = remember { mutableStateListOf<Product>() }

        var products = productRepository.viewProducts(emptyProductState, emptyProductsListState)

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "View Products",
            style = TextStyle(letterSpacing = 3.sp),
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight(300),
            color = Color.Black,
            fontSize = 33.sp,
            textDecoration = TextDecoration.Underline,

        )

            LazyColumn(){
                items(products){
                    ProductItem(
                        name = it.name,
                        quantity = it.quantity,
                        price = it.price,
                        id = it.id,
                        navController = navController,
                        productRepository = productRepository
                    )
                }
            }

            }

        }

@Composable
fun ProductItem(name:String, quantity:String, price:String, id:String,
                navController:NavHostController, productRepository:productviewmodel) {

    Column(modifier = Modifier.fillMaxWidth()
        .padding(13.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = name,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight(700),
            color = Color.Black,
            fontSize = 27.sp,)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = quantity,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight(700),
            color = Color.Black,
            fontSize = 25.sp,)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = price,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight(700),
            color = Color.Black,
            fontSize = 20.sp,)
        Spacer(modifier = Modifier.height(10.dp))


        Button(onClick = {
            productRepository.deleteProduct(id)
        },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(158, 210, 190)
            )) {
            Text(text = "Delete",
                style = TextStyle(letterSpacing = 2.sp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(200),
                color = Color.Black,
                fontSize = 20.sp,)
        }
        Spacer(modifier = Modifier.height(7.dp))
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE+"/$id")
        },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(158, 210, 190),

            )) {
            Text(text = "Update",
                style = TextStyle(letterSpacing = 2.sp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(200),
                color = Color.Black,
                fontSize = 20.sp,)
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    Divider()//divides line

}

@Preview
@Composable
fun View() {
    ViewProductsScreen(rememberNavController())

}