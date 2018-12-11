package com.ujujzk.domain.gateway

import com.ujujzk.domain.model.Cat
import io.reactivex.Single


interface CatGateway {

    fun getCats(): Single<List<Cat>>

    fun getCatByName(): Single<Cat>
}