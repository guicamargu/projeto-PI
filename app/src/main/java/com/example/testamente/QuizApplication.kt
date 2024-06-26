package com.example.testamente

import android.app.Application
import com.example.testamente.model.AppDatabase

class QuizApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}
