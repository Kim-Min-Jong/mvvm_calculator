package com.nbcamp.mvvm_calculator

import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.nbcamp.mvvm_calculator.base.BaseActivity
import com.nbcamp.mvvm_calculator.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel by viewModels<MainViewModel>()
    override fun getViewBinding(layoutId: Int): ActivityMainBinding =
        DataBindingUtil.setContentView(this, layoutId)

    /**
     * lifeCycleOwner 및 ViewModel을 초기화합니다.
     */
    override fun initViews() = with(binding){
        lifecycleOwner = this@MainActivity
        viewModel = mainViewModel
    }

    /**
     * 계산 결과를 Observing합니다.
     */
    override fun observeData() = with(mainViewModel) {
        calculateState.observe(this@MainActivity) { calculateState ->
            when(calculateState) {
                is MainCalculateState.GetResult -> {
                    binding.tvResult.text = calculateState.result.toString()
                }

                is MainCalculateState.FailCalculate -> {
                    binding.tvResult.text = calculateState.message
                }
            }
        }
    }
}
