package com.example.testamente.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question_table")
data class Question(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val questionText: String,
    val options: List<String>,
    val correctAnswer: String,
    val createdBy: String // username of the teacher who created the question
)
