package com.example.gamerapp2semah.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamerapp2semah.R
import com.example.gamerapp2semah.model.News

@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
    onShowSnackbar: (String) -> Unit = {}
) {

    val newsList = listOf(
        News(R.drawable.img1, "Nouveau jeu sorti", "Découvrez le dernier jeu de combat avec des graphismes incroyables."),
        News(R.drawable.img2, "Update majeure disponible", "Nouveaux personnages, nouvelles maps ."),
        News(R.drawable.img3, "Tournoi e-sport", "Inscriptions ouvertes pour le tournoi annuel avec un prize pool de 50,000€."),
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(newsList) { news ->
            NewsItem(
                news = news,
                onReadMoreClick = {
                    onShowSnackbar("Coming soon")
                },
                onCardClick = {
                    onShowSnackbar("Coming soon")
                }
            )
        }
    }
}

@Composable
fun NewsItem(
    news: News,
    onReadMoreClick: () -> Unit,
    onCardClick: () -> Unit
) {
    Card(
        onClick = onCardClick,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(0.9f)
            .height(350.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Image
            Image(
                painter = painterResource(id = news.image),
                contentDescription = "News image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(175.dp)
            )

            Text(
                text = news.title,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )

            Text(
                text = news.description,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                color = MaterialTheme.colorScheme.onSurface
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.BottomEnd
            ) {
                Button(
                    onClick = onReadMoreClick,
                    modifier = Modifier.padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text("Read More", color = MaterialTheme.colorScheme.onPrimary)
                }
            }
        }
    }
}