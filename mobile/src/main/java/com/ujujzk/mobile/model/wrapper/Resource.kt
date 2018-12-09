package com.ujujzk.mobile.model.wrapper

class Resource<out T>(
        val status: ResourceState,
        val data: T?,
        val message: String?) {

    fun <T> success(data: T): Resource<T> = Resource(ResourceState.SUCCESS, data, null)

    fun <T> error(message: String = "ERROR"): Resource<T> = Resource(ResourceState.ERROR, null, message)

    fun <T> loading(): Resource<T> = Resource(ResourceState.LOADING, null, null)

}