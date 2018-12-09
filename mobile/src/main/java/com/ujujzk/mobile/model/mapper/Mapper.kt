package com.ujujzk.mobile.model.mapper

interface Mapper<out V, in D> {
    fun mapToView(type: D) : V
}