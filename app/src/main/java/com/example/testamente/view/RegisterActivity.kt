package com.example.testamente.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.testamente.R
import com.example.testamente.controller.UserViewModel
import com.example.testamente.databinding.ActivityRegisterBinding
import com.example.testamente.model.User

class RegisterActivity : AppCompatActivity() {
    private val userViewModel: UserViewModel by viewModels()
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            finish()
        }

        binding.buttonCadastrar.setOnClickListener {
            val username = binding.editTextNome.text.toString()
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextSenha.text.toString()
            val confirmarSenha = binding.editTextConfirmarSenha.text.toString()
            val role = if (binding.isTeacher.isChecked) "teacher" else "student"

            if (password == confirmarSenha) {
                val user = User(username, email, password, role)
                userViewModel.registerUser(user)
            } else {
                // Mostrar mensagem de erro: senhas não coincidem
            }
        }
    }
}
