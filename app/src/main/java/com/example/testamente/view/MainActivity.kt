package com.example.testamente.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.testamente.R
import com.example.testamente.controller.UserViewModel
import com.example.testamente.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()

            userViewModel.loginUser(username, password) { user ->
                if (user != null) {
                    // Successful login
                    // Redirect to the appropriate activity based on user role
                    if (user.role == "teacher") {
                        // Redirect to TeacherActivity (create this activity later)
                    } else {
                        // Redirect to StudentActivity (create this activity later)
                    }
                } else {
                    // Show error message
                }
            }
        }

        binding.registerButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
