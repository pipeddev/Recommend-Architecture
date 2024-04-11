package com.pipe.d.dev.recommendarch.common.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareFragmentViewModel: ViewModel() {
    val isDismiss = MutableLiveData<Boolean>()
}