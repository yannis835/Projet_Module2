package com.example.module2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module2.databinding.ActivityCalendarBinding

enum class Category {CONNECTION,CALENDAR,INFORMATIONS}


class CalendarActivity : AppCompatActivity() {

    companion object{
        const val extraKey ="extraKey"
    }
    lateinit var binding:ActivityCalendarBinding
    lateinit var currentCategory : Category

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val category =intent.getSerializableExtra(extraKey) as? Category
        currentCategory=category ?: Category.CONNECTION
        supportActionBar?.title = categoryName()
    }

    private fun categoryName(): String{
        return when(currentCategory){
            Category.CONNECTION-> "Connextion"
            Category.CALENDAR-> "Calendar"
            Category.INFORMATIONS->"Informations"
        }
    }

}