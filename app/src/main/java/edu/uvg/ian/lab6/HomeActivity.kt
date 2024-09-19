package edu.uvg.ian.lab6

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
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
import edu.uvg.ian.lab6.ui.theme.Lab6Theme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6Theme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    var selectedRecipeIndex by remember { mutableIntStateOf(0) }

    val recipes = listOf(
        Recipe(
            title = "Prime Rib Roast",
            time = "5HR",
            likes = 685,
            comments = 107,
            description = "El Prime Rib Roast es un corte clásico y tierno de res, ideal para ocasiones especiales. Su sabor jugoso y textura suave lo convierten en una opción favorita para cenas festivas. Cocido lentamente en el horno, cada rebanada ofrece un balance perfecto entre grasa y carne magra, creando una explosión de sabores en cada bocado. Sirve este platillo acompañado de una salsa au jus y papas al horno para una experiencia inolvidable.",
            imageRes = R.drawable.recipe_image
        ),
        Recipe(
            title = "Lasagna",
            time = "2HR",
            likes = 1203,
            comments = 456,
            description = "Esta lasaña es perfecta para reuniones familiares, combinando capas de pasta fresca con una deliciosa mezcla de carne molida, salsa de tomate y quesos derretidos. Suave y reconfortante, cada capa está llena de sabores italianos tradicionales, que van desde el orégano y la albahaca hasta la ricotta cremosa y el queso mozzarella dorado. Hornea hasta que burbujee y el queso se dore para una comida casera que dejará a todos satisfechos."
            ,
            imageRes = R.drawable.lasagna
        ),
        Recipe(
            title = "Chicken Soup",
            time = "1HR 30MIN",
            likes = 902,
            comments = 235,
            description = "Una sopa de pollo sustanciosa que calienta el alma. Hecha con tiernos trozos de pollo, zanahorias, apio y papas, todo cocido a fuego lento en un sabroso caldo casero. Esta sopa es perfecta para esos días fríos o cuando necesitas algo reconfortante. Un toque de hierbas frescas como el perejil o el tomillo le añade frescura, mientras que los fideos o arroz la hacen aún más completa.",
            imageRes = R.drawable.recipe_image
        )
    )

    // Fondo blanco en la pantalla completa
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) // Fondo blanco
    ) {
        TopBar()
        CategoryTabs()
        Spacer(modifier = Modifier.height(16.dp))
        RecipeCarousel(recipes = recipes, onRecipeSelected = { index ->
            selectedRecipeIndex = index
        })
        Spacer(modifier = Modifier.height(16.dp))
        RecipeDetails(recipe = recipes[selectedRecipeIndex])
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    val context = LocalContext.current
    TopAppBar(
        title = {
            Text(
                "POPULAR RECIPES",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                // Acción para ir a MenuActivity
                context.startActivity(Intent(context, MenuActivity::class.java))
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu Icon"
                )
            }
        },
        actions = {
            IconButton(onClick = { /* TODO */ }) {
                Icon(painterResource(R.drawable.ic_search), contentDescription = "Search")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFE57373), // Color de fondo
            titleContentColor = Color.White, // Color del texto del título
            actionIconContentColor = Color.White // Color de los iconos
        )
    )
}

@Composable
fun CategoryTabs() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        listOf("APPETIZERS", "ENTREES", "DESSERT").forEach { category ->
            Text(
                text = category,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun RecipeCarousel(recipes: List<Recipe>, onRecipeSelected: (Int) -> Unit) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(recipes.size) { index ->
            val recipe = recipes[index]
            Image(
                painter = painterResource(recipe.imageRes),
                contentDescription = recipe.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { onRecipeSelected(index) }
            )
        }
    }
}

@Composable
fun RecipeDetails(recipe: Recipe) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = recipe.title,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconWithText(R.drawable.ic_timer, recipe.time)
            IconWithText(R.drawable.ic_favorite, recipe.likes.toString())
            IconWithText(R.drawable.ic_comment, recipe.comments.toString())
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = recipe.description,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 14.sp
        )
    }
}

@Composable
fun IconWithText(iconRes: Int, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .padding(end = 4.dp)
        )
        Text(text = text, color = Color.Gray, fontSize = 14.sp)
    }
}

// Data class para las recetas
data class Recipe(
    val title: String,
    val time: String,
    val likes: Int,
    val comments: Int,
    val description: String,
    val imageRes: Int
)

@Preview
@Composable
fun HomeScreenPreview() {
    Lab6Theme {
        HomeScreen()
    }
}
