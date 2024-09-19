package edu.uvg.ian.lab6

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext
import edu.uvg.ian.lab6.ui.theme.Lab6Theme

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6Theme {
                MenuScreen()
            }
        }
    }
}

@Composable
fun MenuScreen() {
    val context = LocalContext.current // Obtenemos el contexto

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEF5350)) // Fondo rojo del menú
    ) {
        // Opciones del menú
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 24.dp, top = 24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                MenuButton(text = "POPULAR RECIPES") {
                    context.startActivity(Intent(context, HomeActivity::class.java))
                }
                MenuButton(text = "SAVED RECIPES") {
                    context.startActivity(Intent(context, PrimeRibRoastActivity::class.java))
                }
                MenuButton(text = "SHOPPING LIST") {
                    context.startActivity(Intent(context, RecipeCompleteActivity::class.java))
                }
                MenuButton(text = "SETTINGS") {
                    // Puedes agregar una actividad para settings aquí si lo necesitas
                }
            }

            // Perfil en la parte inferior
            Row(
                modifier = Modifier.padding(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.user_image), // Imagen de perfil
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.White, CircleShape)
                        .padding(2.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "HARRY TRUMAN",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // Botón de menú en la esquina superior derecha
        IconButton(
            onClick = { /* Acción del botón de menú */ },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(24.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color.White
            )
        }
    }
}

@Composable
fun MenuButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier

            .padding(vertical = 8.dp)
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    Lab6Theme {
        MenuScreen()
    }
}
