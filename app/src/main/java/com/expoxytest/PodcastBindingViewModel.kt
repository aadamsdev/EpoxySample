package com.expoxytest

import com.airbnb.epoxy.EpoxyController

class PodcastBindingViewModel(private val podcastModel: PodcastModel) : BaseBindingViewModel() {

    override fun bindModel(controller: EpoxyController) {
        val bindingViewModel = PodcastViewLayoutBindingModel_()
                .id(podcastModel.id)
                .title(podcastModel.podcastName)
        bindingViewModel.addTo(controller)
    }
}