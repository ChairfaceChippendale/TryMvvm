package com.ujujzk.mobile.model

class Progress private constructor(val show: Boolean, val massage: String){
    companion object {

        fun  show(message: String): Progress = Progress(true, message)

        fun  hide(): Progress = Progress(false, "")

    }

}