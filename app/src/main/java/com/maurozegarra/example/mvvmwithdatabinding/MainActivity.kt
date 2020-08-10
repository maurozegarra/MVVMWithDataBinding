package com.maurozegarra.example.mvvmwithdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.maurozegarra.example.mvvmwithdatabinding.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            button.setOnClickListener {
                lifecycleScope.launch {
                    progress.visibility = View.VISIBLE
                    message.text = withContext(Dispatchers.IO) {
                        Thread.sleep(2_000)
                        if (user.text.isNotEmpty() && pass.text.isNotEmpty()) "Success" else "Failure"
                    }
                    progress.visibility = View.GONE
                }
            }
        }
    }
}
