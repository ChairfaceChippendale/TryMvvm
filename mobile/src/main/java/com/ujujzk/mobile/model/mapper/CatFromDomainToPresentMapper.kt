package com.ujujzk.mobile.model.mapper

import com.ujujzk.domain.model.Cat
import com.ujujzk.mobile.model.VCat
import javax.inject.Inject

open class CatFromDomainToPresentMapper  @Inject constructor(): Mapper<VCat, Cat> {
    override fun mapToView(type: Cat): VCat = VCat(type.name, type.imageUrl, type.nya)
}