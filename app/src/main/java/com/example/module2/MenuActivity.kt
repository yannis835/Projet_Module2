package com.example.module2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module2.databinding.ActivityMenuBinding

enum class Category {SIGNIN,CALENDAR,INFORMATIONS}
class MenuActivity : AppCompatActivity() {
    companion object{
        const val extraKey ="extraKey"
    }
    lateinit var binding: ActivityMenuBinding
    lateinit var currentCategory : Category
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val category =intent.getSerializableExtra(extraKey) as? Category
        currentCategory=category ?: Category.SIGNIN
        supportActionBar?.title = categoryName()
    }

    private fun categoryName(): String{
        return when(currentCategory){
            Category.SIGNIN-> "SignIn"
            Category.CALENDAR-> "Calendar"
            Category.INFORMATIONS->"Informations"
        }
    }
}