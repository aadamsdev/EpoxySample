package com.expoxytest

import com.airbnb.epoxy.EpoxyController

class StationBindingViewModel(private val stationModel: StationModel) : BaseBindingViewModel() {

    private var bindingViewModel: StationViewLayoutBindingModel_? = StationViewLayoutBindingModel_()

    init {
        bindingViewModel?.id(stationModel.id)
    }

    override fun bindModel(controller: EpoxyController) {
        bindingViewModel?.title(stationModel.name)
        bindingViewModel?.addTo(controller)
    }
}