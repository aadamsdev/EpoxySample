package com.expoxytest

import com.airbnb.epoxy.TypedEpoxyController

class StationController() : TypedEpoxyController<List<BaseBindingViewModel>>() {


    private val TAG = StationController::class.java.simpleName

    override fun buildModels(data: List<BaseBindingViewModel>?) {
        data?.forEach({
            it.bindModel(this)
        })
    }
}