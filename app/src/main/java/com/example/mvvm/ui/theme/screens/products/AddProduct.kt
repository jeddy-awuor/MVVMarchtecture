package com.example.mvvm.ui.theme.screens.products


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.data.productviewmodel
import com.example.mvvm.navigation.ROUTE_VIEW

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductsScreen(navController: NavHostController) {
    var context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(243, 253, 232)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Add Product",
            style = TextStyle(letterSpacing = 2.sp),
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight(300),
            color = Color.Black,
            fontSize = 33.sp,
            textDecoration = TextDecoration.Underline
        )

        var productName by remember { mutableStateOf(TextFieldValue("")) }
        var productQuantity by remember { mutableStateOf(TextFieldValue("")) }
        var productPrice by remember { mutableStateOf(TextFieldValue("")) }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productName,
            onValueChange = { productName = it },
            label = {
                Text(text = "Product name *",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(100),
                    color = Color.Black,
                    fontSize = 20.sp,)
                    },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedBorderColor = Color(207, 239, 232, 255),
                unfocusedBorderColor = Color.Black,
            ),
            shape = RoundedCornerShape(25.dp),
        )

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = productQuantity,
            onValueChange = { productQuantity = it },
            label = {
                Text(text = "Product quantity *",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(100),
                color = Color.Black,
                fontSize = 20.sp,)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedBorderColor = Color(207, 239, 232, 255),
                unfocusedBorderColor = Color.Black,
            ),
            shape = RoundedCornerShape(25.dp),
        )

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = productPrice,
            onValueChange = { productPrice = it },
            label = { Text(text = "Product price *",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(100),
                color = Color.Black,
                fontSize = 20.sp, ) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedBorderColor = Color(207, 239, 232, 255),
                unfocusedBorderColor = Color.Black,
            ),
            shape = RoundedCornerShape(25.dp),
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            //-----------WRITE THE SAVE LOGIC HERE---------------//
            var productRepository = productviewmodel(navController,context)
            productRepository.saveProduct(productName.text.trim(),productQuantity.text.trim(),
                productPrice.text)
        },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
            containerColor = Color(158, 210, 190)
        ),
        ) {
            Text(text = "Save",
                style = TextStyle(letterSpacing = 2.sp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(300),
                color = Color.Black,
                fontSize = 20.sp,)
        }

    }
}

@Preview
@Composable
fun Addpr() {
    AddProductsScreen(rememberNavController())

}