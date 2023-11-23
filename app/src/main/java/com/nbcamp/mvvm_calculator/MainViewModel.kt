package com.nbcamp.mvvm_calculator

import androidx.lifecycle.MutableLiveData
import com.nbcamp.mvvm_calculator.base.BaseViewModel

class MainViewModel : BaseViewModel<MainCalculateState>() {
    override val firstOperand: MutableLiveData<String> = MutableLiveData("")
    override val secondOperand: MutableLiveData<String> = MutableLiveData("")

    /**
     * @param operator 계산 타입
     *
     * DataBinding을 통해 operand 및 계산 타입을 입력 받고 해당하는 타입에 따라 계산을 진행합니다.
     * 계산이 완료되면 Result를 value에 지정합니다. operand가 null일때는 실패 값을 지정합니다.
     */
    fun calculate(operator: ButtonType) {
        if(firstOperand.value == null || secondOperand.value == null) {
            _calculateState.value = MainCalculateState.FailCalculate("계산 실패")
            return
        }

        val firstValue = firstOperand.value!!.toInt()
        val secondValue = secondOperand.value!!.toInt()
        when(operator) {
            ButtonType.PLUS -> {
                _calculateState.value = MainCalculateState.GetResult(firstValue + secondValue)
            }
            ButtonType.MINUS -> {
                _calculateState.value = MainCalculateState.GetResult(firstValue - secondValue)
            }
            ButtonType.MULTIPLE -> {
                _calculateState.value = MainCalculateState.GetResult(firstValue * secondValue)
            }
            ButtonType.DIVIDE -> {
                _calculateState.value = MainCalculateState.GetResult(firstValue / secondValue)
            }
        }
    }
}


