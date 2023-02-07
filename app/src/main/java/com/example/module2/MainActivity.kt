package com.example.module2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.example.module2.databinding.ActivityMainBinding

lateinit var database: DatabaseReference


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buttonListener()
        database = Firebase.database("https://module2androidstudio-default-rtdb.europe-west1.firebasedatabase.app/").reference
        writeNewUser()


    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }

    fun writeNewUser() {
        val user = User("yannis","yannis.mouton@isen.yncrea.fr")

        DataBaseHelper.database.child("users").child("0").setValue(user)
    }

    private fun buttonListener(){
        binding.buttonCalendar.setOnClickListener{
            showCategory(Category.CALENDAR)
        }
        binding.buttonSignIn1.setOnClickListener{
            showCategory(Category.SignIn)

        }

        binding.buttonInfo.setOnClickListener{
            showCategory(Category.INFORMATIONS)

        }
    }

    private fun showCategory(category: Category){
        val intent = Intent( this, CalendarActivity::class.java)
        intent.putExtra(CalendarActivity.extraKey, category)
        startActivity(intent)
    }

}
@IgnoreExtraProperties
data class User(val username: String? = null, val email: String? = null) {
    // Null default values create a no-argument default constructor, which is needed
    // for deserialization from a DataSnapshot.
}