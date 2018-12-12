package com.ujujzk.data.cats

import com.ujujzk.domain.gateway.CatGateway
import com.ujujzk.domain.model.Cat
import io.reactivex.Single
import javax.inject.Inject


class CatsGatewayImpl @Inject constructor() : CatGateway {
    override fun getCats(): Single<List<Cat>> {
        return Single.just<List<Cat>>(cats)
    }

    override fun getCatByName(): Single<Cat> {
        return Single.error(Exception())
    }

    val cats = listOf<Cat>(
            Cat("Mike", "https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg", true),
            Cat("Butch", "https://i.redd.it/tpsnoz5bzo501.jpg", true),
            Cat("Dude", "https://i.redd.it/qn7f9oqu7o501.jpg", false),
            Cat("Fur", "https://i.redd.it/j6myfqglup501.jpg", true),
            Cat("Tom", "https://i.redd.it/0h2gm1ix6p501.jpg", true),
            Cat("Aphonya", "https://i.redd.it/k98uzl68eh501.jpg", false)
    )

}