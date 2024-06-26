package com.example.testamente.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    val username: String,
    val email: String,
    val password: String,
    val role: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
