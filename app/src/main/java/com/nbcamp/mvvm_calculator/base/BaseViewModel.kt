package com.nbcamp.mvvm_calculator.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nbcamp.mvvm_calculator.MainCalculateState

/**
 * @property firstOperand 첫번째 피연산자 추상화
 * @property secondOperand 두번째 피연산자 추상화
 */
abstract class BaseViewModel<VS: MainCalculateState>: ViewModel() {
    abstract val firstOperand: MutableLiveData<String>
    abstract val secondOperand: MutableLiveData<String>

    protected val _calculateState: MutableLiveData<VS> = MutableLiveData()
    val calculateState = _calculateState
}
