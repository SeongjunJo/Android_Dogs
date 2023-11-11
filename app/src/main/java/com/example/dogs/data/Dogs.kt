package com.example.dogs.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.dogs.R

data class Dog (
    @StringRes val name : Int,
    @StringRes val description : Int,
    @DrawableRes val image : Int
)

val Dogs = mutableListOf<Dog>(
    Dog(R.string.dog_1_name, R.string.dog_1_description, R.drawable.beagle),
    Dog(R.string.dog_2_name, R.string.dog_2_description, R.drawable.border_collie),
    Dog(R.string.dog_3_name, R.string.dog_3_description, R.drawable.dachshund),
    Dog(R.string.dog_4_name, R.string.dog_4_description, R.drawable.german_shepherd),
    Dog(R.string.dog_5_name, R.string.dog_5_description, R.drawable.golden_retriever),
    Dog(R.string.dog_6_name, R.string.dog_6_description, R.drawable.malamute),
    Dog(R.string.dog_7_name, R.string.dog_7_description, R.drawable.maltipoo),
    Dog(R.string.dog_8_name, R.string.dog_8_description, R.drawable.samoyed),
    Dog(R.string.dog_9_name, R.string.dog_9_description, R.drawable.shih_tzu),
    Dog(R.string.dog_10_name, R.string.dog_10_description, R.drawable.welshcorgi)
)