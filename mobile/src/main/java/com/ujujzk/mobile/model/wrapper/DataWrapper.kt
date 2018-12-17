package com.ujujzk.mobile.model.wrapper

class DataWrapper<out T> private constructor(val status: DataState,
                                             val data: T?,
                                             val message: String){

    companion object {

        fun <T> success(data: T, message: String = "success"): DataWrapper<T> = DataWrapper(DataState.SUCCESS, data, message)

        fun <T> error(message: String = "Unknown error"): DataWrapper<T> = DataWrapper(DataState.ERROR, null, message)

    }

}