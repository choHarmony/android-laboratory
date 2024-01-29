package com.example.hilt_test.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.hilt_test.R
import com.example.hilt_test.databinding.ActivityMainBinding
import com.example.hilt_test.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels() // 의존성 주입

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainVm = this@MainActivity.viewModel

        viewModel.num.observe(this, Observer { value ->
            // value가 변경될 때 수행할 동작을 여기에 작성
            // 예: UI 업데이트 등
            binding.text.text = value.toString()
        })
    }
}