package com.nbcamp.mvvm_calculator.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nbcamp.mvvm_calculator.MainCalculateState

abstract class BaseViewModel<VS: MainCalculateState>: ViewModel() {
    protected val firstOperand: MutableLiveData<String> = MutableLiveData("")
    protected val secondOperand: MutableLiveData<String> = MutableLiveData("")

    protected val _calculateState: MutableLiveData<VS> = MutableLiveData()
    val calculateState = _calculateState
}
