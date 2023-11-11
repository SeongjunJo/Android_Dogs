@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.dogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dogs.data.Dog
import com.example.dogs.ui.theme.DogsTheme

@Composable
fun DogCard(dog : Dog, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .clickable { expanded = !expanded }
            .padding(5.dp)
            .let { if(expanded) it.fillMaxHeight() else it},
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
       Column(
           modifier = Modifier.padding(vertical = 5.dp, horizontal = 15.dp)
       ) {
           Text(
               text = stringResource(dog.name),
               style = MaterialTheme.typography.titleLarge,
               modifier = modifier
                   .heightIn(64.dp)
                   .fillMaxSize()
                   .wrapContentSize(Alignment.Center),
               textAlign = TextAlign.Center
           )
           Spacer(modifier = Modifier.height(5.dp))
           Image(
               painter = painterResource(dog.image),
               contentDescription = stringResource(dog.name) + " image",
               modifier = Modifier
                   .height(120.dp)
                   .width(192.dp)
                   .clip(MaterialTheme.shapes.small),
               contentScale = ContentScale.Crop
           )
           Spacer(modifier = Modifier.height(20.dp))
           if(expanded) {
               Text(
                   text = stringResource(dog.description),
                   style = MaterialTheme.typography.bodyMedium,
               )
           }
       }
    }
}

@Composable
fun TopAppBar() {
    androidx.compose.material3.TopAppBar(
        title = {
            Text(
                text = "I Love Dogs",
                style = MaterialTheme.typography.displayLarge
            )
            Spacer(modifier = Modifier.height(80.dp))
        }
    )
}

@Preview (showBackground = true)
@Composable
private fun CardPreview_Light() {
    DogsTheme{
        DogCard(
            dog = Dog(R.string.dog_1_name, R.string.dog_1_description, R.drawable.beagle)
        )
    }
}

@Preview (showBackground = true)
@Composable
private fun CardPreview_Dark() {
    DogsTheme(darkTheme = true) {
        DogCard(
            dog = Dog(R.string.dog_1_name, R.string.dog_1_description, R.drawable.beagle)
        )
    }
}