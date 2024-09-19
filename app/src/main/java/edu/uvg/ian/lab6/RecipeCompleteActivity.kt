package edu.uvg.ian.lab6
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class RecipeCompleteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YouDidItPopup()
        }
    }
}

@Composable
fun YouDidItPopup() {
    val context = LocalContext.current
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x80000000)) // Fondo semi-transparente
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth(0.8f) // Ancho de la tarjeta (80% del ancho de la pantalla)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Fila para el menú y el botón de cerrar (X)
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Botón de menú (izquierda)
                    IconButton(onClick = {
                        // Acción para ir a MenuActivity

                        context.startActivity(Intent(context, MenuActivity::class.java))
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu Icon"
                        )
                    }

                    // Botón de cerrar (derecha)
                    IconButton(onClick = { /* Acción para cerrar el popup */ }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Close Icon")
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Título
                Text(
                    text = "YOU DID IT!",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color(0xFF004BA0),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Subtítulo
                Text(
                    text = "Let your friends know about it",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Fila de íconos de redes sociales
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    SocialMediaIcon(R.drawable.insta)
                    SocialMediaIcon(R.drawable.facebook)
                    SocialMediaIcon(R.drawable.x)
                    SocialMediaIcon(R.drawable.discord)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Texto para dejar una reseña
                Text(
                    text = "Leave a review",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Fila de estrellas (calificación)
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    repeat(5) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Star",
                            tint = MaterialTheme.colorScheme.primary
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun SocialMediaIcon(iconRes: Int) {
    Image(
        painter = painterResource(id = iconRes),
        contentDescription = "Social Media Icon",
        modifier = Modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(Color(0xFFFF6F61)) // Fondo rojo-anaranjado
            .padding(12.dp),
        contentScale = ContentScale.Crop
    )
}

// Vista previa de la ventana emergente
@Preview(showBackground = true)
@Composable
fun PreviewYouDidItPopup() {
    YouDidItPopup()
}
