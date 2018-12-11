package com.ujujzk.mobile.model.mapper

import com.ujujzk.domain.model.Cat
import com.ujujzk.mobile.model.CatView
import javax.inject.Inject

open class CatFromDomainToPresentMapper  : Mapper<CatView, Cat> {
    override fun mapToView(type: Cat): CatView = CatView(type.name, type.imageUrl, type.nya)
}