package com.example.inspirationapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.inspirationapp.data.QuoteApi
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteScreen(onBackClick: () -> Unit,
                toTheEnd: () -> Unit) {
    var quote by remember { mutableStateOf("Chargement...") }

    LaunchedEffect(Unit) {
        quote = try {
            QuoteApi.getQuote()
        } catch (e: Exception) {
            "Erreur lors de la récupération."
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Citation inspirante") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Retour"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = quote,
                style = MaterialTheme.typography.bodyLarge
            )

            Button(onClick = toTheEnd) {
                Text("Vers la page de fin")
            }
        }
    }
}
