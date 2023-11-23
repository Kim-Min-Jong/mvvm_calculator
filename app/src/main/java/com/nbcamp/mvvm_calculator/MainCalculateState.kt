package com.nbcamp.mvvm_calculator

/**
 * 계산 결과에 따라 분기 처리할 sealed class 입니다.
 */
sealed class MainCalculateState{
    /**
     * @param message 계산 실패 시 보여줄 메세지
     */
    data class FailCalculate(
        val message: String
    ) : MainCalculateState()

    /**
     * @param result 계산 결과
     */
    data class GetResult(
        val result: Number
    ): MainCalculateState()
}
