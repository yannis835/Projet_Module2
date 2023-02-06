package com.example.module2

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DataBaseHelper {
    companion object{
        val database = Firebase.database("https://module2androidstudio-default-rtdb.europe-west1.firebasedatabase.app/").reference
    }
}