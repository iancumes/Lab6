package edu.uvg.ian.lab6


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uvg.ian.lab6.ui.theme.Lab6Theme

class PrimeRibRoastActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6Theme {
                PrimeRibRoastScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimeRibRoastScreen() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Prime Rib Roast", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = {
                        // Acci√≥n para ir a MenuActivity

                        context.startActivity(Intent(context, MenuActivity::class.java))
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu Icon"
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Esto asegura que el contenido no se superponga con la TopAppBar
                .padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Secci√≥n de la Imagen
            item {
                Image(
                    painter = painterResource(id = R.drawable.costilla), // Reemplaza con tu recurso de imagen
                    contentDescription = "Prime Rib Roast",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp) // Establecer la altura de la imagen
                )

                // Secci√≥n de estrellas de calificaci√≥n
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    repeat(4) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Star",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Half Star",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }

                // Secci√≥n de t√≠tulo y descripci√≥n
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Prime Rib Roast",
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = Blue
                        )
                    )
                    Text(
                        text = "The Prime Rib Roast is a classic and tender cut of beef...",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }

            // Secci√≥n de lista de compras con icono redondeado
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Box(
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.shopi), // Reemplaza con el √≠cono
                                contentDescription = "Lock Icon",
                                modifier = Modifier
                                    .size(90.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        ShoppingSection(
                            "SHOPPING LIST", listOf(
                                "1 Prime Rib Roast (8 pounds)",
                                "1/2 cup good-quality balsamic vinegar",
                                "1 cup packed Italian parsley leaves",
                                "8 cloves garlic, minced",
                                "1/4 teaspoon salt",
                                "Freshly ground pepper to taste",
                                "1 cup water",
                                "3 drops Worcestershire sauce"
                            )
                        )
                    }
                }
            }

            // Secci√≥n de preparaci√≥n
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Box(
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cook), // Reemplaza con el √≠cono de cocinar
                                contentDescription = "Cooking Icon",
                                modifier = Modifier
                                    .size(32.dp)
                                    .align(Alignment.Center)
                            )
                        }
                        PreparationSection(
                            "PREPARATION", listOf(
                                "Preheat oven to 350¬∞F. Let roast stand at room temperature for 1 hour.",
                                "In a small saucepan, boil balsamic vinegar until it reduces to 1/4 cup (about 3 minutes).",
                                "Finely mince parsley, mix with garlic, salt, and pepper, and spread over roast.",
                                "After slicing the roast, add any accumulated meat juices to the balsamic sauce. Serve the meat slices on warmed plates with balsamic sauce on the side."
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ShoppingSection(title: String, items: List<String>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Blue,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )
        items.forEach { item ->
            ShoppingItem(item)
        }
    }
}

@Composable
fun PreparationSection(title: String, steps: List<String>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )
        steps.forEach { step ->
            PreparationStep(step)
        }
    }
}

@Composable
fun ShoppingItem(item: String) {
    Text(
        text = item,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun PreparationStep(step: String) {
    Text(
        text = step,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewPrimeRibRoastScreen() {
    Lab6Theme {
        PrimeRibRoastScreen()
    }
}
