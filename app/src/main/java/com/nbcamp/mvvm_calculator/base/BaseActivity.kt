package com.nbcamp.mvvm_calculator.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * BaseActivity로 추상화하여 ViewBinding을 처리합니다.
 *
 * @param layoutId 액티비티의 layout id - Int
 * @see initViews
 * @see observeData
 */
abstract class BaseActivity<VB : ViewBinding>(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {

    protected lateinit var binding: VB
    abstract fun getViewBinding(@LayoutRes layoutId: Int): VB

    /**
     * 각종 뷰 초기화 블럭
     */
    abstract fun initViews()

    /**
     * LiveData를 관찰하는 블럭
     */
    abstract fun observeData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding(layoutId)
        setContentView(binding.root)
        initViews()
        observeData()
    }


}
