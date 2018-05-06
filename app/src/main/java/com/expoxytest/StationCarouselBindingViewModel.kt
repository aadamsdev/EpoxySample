package com.expoxytest

import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController

class StationCarouselBindingViewModel(val stationModels: List<StationModel>) : BaseBindingViewModel() {

    override fun bindModel(controller: EpoxyController) {
        val bindingViewModels: ArrayList<StationViewLayoutBindingModel_>? = ArrayList()

        stationModels.forEach {
            val stationViewLayoutBindingModel = StationViewLayoutBindingModel_()
                    .id(it.id)
                    .title(it.name)

            bindingViewModels?.add(stationViewLayoutBindingModel)
        }

        bindingViewModels?.let {
            CarouselModel_()
                    .id(1000)
                .models(it)
                    .addTo(controller)
        }
    }
}