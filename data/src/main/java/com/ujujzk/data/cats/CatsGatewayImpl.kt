package com.ujujzk.data.cats

import com.ujujzk.domain.gateway.CatGateway
import com.ujujzk.domain.model.Cat
import io.reactivex.Single
import javax.inject.Inject


class CatsGatewayImpl @Inject constructor(): CatGateway {
    override fun getCats(): Single<List<Cat>> {
        return Single.just<List<Cat>>(emptyList())
    }

    override fun getCatByName(): Single<Cat> {
        return Single.error(Exception())
    }
}