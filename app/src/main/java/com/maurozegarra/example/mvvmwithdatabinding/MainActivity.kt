package com.maurozegarra.example.mvvmwithdatabinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.maurozegarra.example.mvvmwithdatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainPresenter.View {
    private val presenter = MainPresenter(this, lifecycleScope)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            button.setOnClickListener {
                presenter.onButtonClicked(user.text.toString(), pass.text.toString())
            }
        }
    }

    override fun setProgressVisible(boolean: Boolean) {
        if (boolean) {
            binding.progress.visibility =
                android.view.View.VISIBLE
        } else {
            binding.progress.visibility = android.view.View.GONE
        }
    }

    override fun setMessage(message: String) {
        binding.message.text = message
    }
}
