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
            Cat("Mike", "http://faydark-coon.com/images/photos/243/perfect-cat-cuba-2.jpg", true),
            Cat("Butch", "https://pbs.twimg.com/profile_images/703554305782054912/osSSydtK_400x400.jpg", true),
            Cat("Dude", "https://is1-ssl.mzstatic.com/image/thumb/Purple118/v4/bc/ba/16/bcba16f8-49ce-c6b9-6226-d7d85a8556ea/source/256x256bb.jpg", false),
            Cat("Fur", "https://cdn140.picsart.com/257908300012202.jpg?c256x256", true)
    )

}