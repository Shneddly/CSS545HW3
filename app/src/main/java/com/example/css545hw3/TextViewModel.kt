package com.example.css545hw3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextViewModel : ViewModel() {
    private val _enteredText = MutableLiveData<String>()
    val enteredText: LiveData<String> = _enteredText

    fun setEnteredText(text: String) {
        _enteredText.value = text
    }
}