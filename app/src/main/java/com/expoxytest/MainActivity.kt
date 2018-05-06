package com.expoxytest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

//    private val podcasts: ArrayList<PodcastModel>? = ArrayList()
//    private val stations: ArrayList<StationModel>? = ArrayList()

    private val bindingViewModels: ArrayList<BaseBindingViewModel>? = ArrayList()
    private val carouselStationModels= ArrayList<StationModel>()
    private val controller: StationController = StationController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 1..10) {
            val podcastModel = PodcastModel(i, i.toString())
            bindingViewModels?.add(PodcastBindingViewModel(podcastModel))
        }

        for (i in 11..20) {
            val stationModel = StationModel(i, i.toString())
            carouselStationModels.add(stationModel)
        }

        val carouselBindingViewModel = StationCarouselBindingViewModel(carouselStationModels)
        bindingViewModels?.add(carouselBindingViewModel)

        recycler_view.setController(controller)


        controller.setData(bindingViewModels)

        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(object : Observer<Long> {
                    override fun onComplete() {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(t: Long) {
                        (bindingViewModels?.lastOrNull() as? StationCarouselBindingViewModel)?.stationModels?.get(0)?.name = t.toString()
                        controller.setData(bindingViewModels)
                    }


                    override fun onError(e: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })
    }


}
