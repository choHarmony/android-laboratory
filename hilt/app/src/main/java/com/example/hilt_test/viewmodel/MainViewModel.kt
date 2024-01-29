package com.example.hilt_test.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hilt_test.model.AddNumber
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val addNumber: AddNumber
) : ViewModel() {

    private val _num = MutableLiveData(0)
    val num: LiveData<Int> get() = _num

    fun onBtnClicked(view: View) {
        setNum(
            addNumber.addNumber(num.value!!)
        )
    }

    private fun setNum(number: Int) {
        _num.value = number
    }


}