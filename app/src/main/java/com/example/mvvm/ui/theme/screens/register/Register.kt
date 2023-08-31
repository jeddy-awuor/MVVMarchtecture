package com.example.mvvm.ui.theme.screens.register

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.mvvm.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController) {
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(243, 253, 232)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Create Your Account ",
            fontFamily = FontFamily.Cursive,
            color = Color.Black,
            fontSize = 35.sp,
        )
        Spacer(modifier = Modifier.height(15.dp))


        Image(painter = painterResource(id = R.drawable.hello) ,
            contentDescription = "sitting",
            modifier = Modifier.size(200.dp),
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = username,
            label = {
                Text(
                    text = "Username",
                    fontFamily = FontFamily.Cursive,
                    color = Color.Black,
                    fontSize = 20.sp,
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(207,239,232,255),
                unfocusedBorderColor = Color.Black,
                textColor = Color.Black
            ),
            shape = RoundedCornerShape(25.dp),
            onValueChange = {
                username = it
            },
        )
        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = email,
            label = {
                Text(
                    text = "Email",
                    fontFamily = FontFamily.Cursive,
                    color = Color.Black,
                    fontSize = 20.sp,
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(207,239,232,255),
                unfocusedBorderColor = Color.Black,
                textColor = Color.Black
            ),
            shape = RoundedCornerShape(25.dp),
            onValueChange = {
                email = it
            },

            )

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = password,
            label = {
                Text(
                    text = "Password",
                    fontFamily = FontFamily.Cursive,
                    color = Color.Black,
                    fontSize = 20.sp,
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(207,239,232,255),
                unfocusedBorderColor = Color.Black,
                textColor = Color.Black
            ),
            shape = RoundedCornerShape(25.dp),
            onValueChange = {
                password = it
            },

            )
        Spacer(modifier = Modifier.height(35.dp))

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color(158, 210, 190)
                ),
            ) {
                Text(
                    text = "Sign Up",
                    style = TextStyle(letterSpacing = 3.sp),
                    fontFamily = FontFamily.Cursive,
                    fontSize = 24.sp,
                )
            }
        }
    }
