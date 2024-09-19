package edu.uvg.ian.lab6

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import edu.uvg.ian.lab6.ui.theme.Lab6Theme


@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6Theme {
                SplashScreen()
            }
        }

        // Delay de 3 segundos antes de lanzar la HomeActivity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, 3000) // 3 segundos de espera
    }
}

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Image(
            painter = painterResource(id = R.drawable.lasagna), // Imagen de fondo
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Superposición roja
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xAAFF0000)) // Transparente con rojo
        )

        // Icono y texto centrados
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.chef_logo), // Icono del chef
                contentDescription = "Chef Logo",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Chef Recipes",
                color = Color.White,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Lab6Theme {
        SplashScreen()
    }
}*/
