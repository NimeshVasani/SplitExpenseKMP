package ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import splitexpensekmp.composeapp.generated.resources.Res
import splitexpensekmp.composeapp.generated.resources.main_logo

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {

    var emailAddress by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val currentFocus = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize().padding(start = 20.dp, end = 20.dp)
            .background(
                color = Color.White
            ).imePadding().pointerInput(Unit) {
                detectTapGestures(onTap = {
                    currentFocus.clearFocus()
                })
            },
        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(Res.drawable.main_logo),
            contentDescription = "main app logo",
            modifier = Modifier.size(200.dp),
            contentScale = Crop
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Welcome Back",
            fontSize = 28.sp,
            fontWeight = W600,
            fontStyle = FontStyle.Normal,
            color = Black
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            emailAddress,
            onValueChange = {
                emailAddress = it
            },
            label = { Text("Email Address") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
            singleLine = true,
            modifier = Modifier.fillMaxWidth().height(60.dp),
            placeholder = { Text("Enter Your Email Address", color = Black.copy(0.5f)) },
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            password,
            onValueChange = {
                password = it
            },
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier.fillMaxWidth().height(60.dp),
            placeholder = { Text("Enter Your password", color = Black.copy(0.5f)) },
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Forgot password?",
            fontSize = 16.sp,
            fontWeight = Normal,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            color = Blue,
            modifier = Modifier.clickable {
                onForgotPasswordClick()
            }.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                onLoginClick()
            },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF18A558)),
            elevation = ButtonDefaults.elevation(defaultElevation = 2.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                "Login", color = Black, fontWeight = W600,
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "New to Split Expense? Register here.",
            fontSize = 18.sp,
            fontWeight = Normal,
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            color = Blue,
            modifier = Modifier.clickable {
                onRegisterClick()
            }
        )
    }
}