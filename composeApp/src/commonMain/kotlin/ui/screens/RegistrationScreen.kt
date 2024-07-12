package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.pointer.pointerInput
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

@Composable
fun RegistrationScreen(onRegisterClick: () -> Unit, onBackClick: () -> Unit) {

    val currentFocus = LocalFocusManager.current
    var emailAddress by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var password2 by remember { mutableStateOf("") }

    Scaffold(topBar = {
        Row(
            modifier = Modifier.clickable { onBackClick() }.padding(top = 56.dp, start = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = "back button",
                modifier = Modifier.size(30.dp),
                tint = Blue
            )
            Text(text = "back", color = Blue)
        }
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize().padding(start = 20.dp, end = 20.dp)
                .background(
                    color = White
                ).imePadding().pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        currentFocus.clearFocus()
                    })
                },
            verticalArrangement = Arrangement.Center,

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Registration",
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
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
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
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                modifier = Modifier.fillMaxWidth().height(60.dp),
                placeholder = { Text("Enter Your password", color = Black.copy(0.5f)) },
            )

            Spacer(modifier = Modifier.height(30.dp))

            OutlinedTextField(
                password2,
                onValueChange = {
                    password2 = it
                },
                label = { Text("Re-type password") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                modifier = Modifier.fillMaxWidth().height(60.dp),
                placeholder = { Text("Enter password again", color = Black.copy(0.5f)) },
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    onRegisterClick()
                },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Blue),
                elevation = ButtonDefaults.elevation(defaultElevation = 2.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    "Register", color = White, fontWeight = W600,
                    fontSize = 20.sp
                )
            }
        }
    }
}