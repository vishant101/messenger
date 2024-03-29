package com.example.messenger.viewmodel
import android.provider.Telephony
import androidx.lifecycle.ViewModel
import com.example.messenger.injection.DaggerViewModelInjector
import com.example.messenger.injection.ViewModelInjector
import com.example.messenger.network.NetworkModule

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is MessageListViewModel -> injector.inject(this)
            is SentMessageViewModel -> injector.inject(this)
            is ReceivedMessageViewModel -> injector.inject(this)
            is SectionBreakViewModel -> injector.inject(this)
        }
    }
}