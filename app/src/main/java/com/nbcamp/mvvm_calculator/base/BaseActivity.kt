package com.nbcamp.mvvm_calculator.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * BaseActivity로 추상화하여
 * ViewBinding 및 BaseViewModel을 처리합니다.
 */
abstract class BaseActivity<VB : ViewBinding>(@LayoutRes private val layoutId: Int) :
    AppCompatActivity() {

    protected lateinit var binding: VB
    abstract fun getViewBinding(@LayoutRes layoutId: Int): VB
    abstract fun initViews()
    abstract fun observeData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding(layoutId)
        setContentView(binding.root)
        initViews()
        observeData()
    }


}
