package com.maurozegarra.example.mvvmwithdatabinding

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.maurozegarra.example.mvvmwithdatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get()

        viewModel.progressVisibility.observe(this, Observer {
            binding.progress.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.message.observe(this, Observer {
            binding.message.text = it
        })

        with(binding) {
            button.setOnClickListener {
                viewModel.onButtonClicked(user.text.toString(), pass.text.toString())
            }
        }
    }
}
