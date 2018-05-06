package com.expoxytest

import com.airbnb.epoxy.EpoxyController


abstract class BaseBindingViewModel() {
    abstract fun bindModel(controller: EpoxyController)
}