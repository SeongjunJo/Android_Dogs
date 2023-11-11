@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.dogs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dogs.data.Dog
import com.example.dogs.data.Dogs
import com.example.dogs.ui.theme.DogsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun DogGrid(dogs : List<Dog>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(dogs) {
            dog -> DogCard(dog = dog)
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        topBar = { TopAppBar() }
    ) {
        Column {
            Spacer(modifier = Modifier.height(70.dp))
            DogGrid(dogs = Dogs, modifier = Modifier.padding(it))
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun LightPreview() {
    DogsTheme {
        DogGrid(dogs = Dogs)
    }
}

@Preview (showBackground = true)
@Composable
private fun DarkPreview() {
    DogsTheme (darkTheme = true) {
        DogGrid(dogs = Dogs)
    }
}