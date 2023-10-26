package com.hmyh.userinfo.utils

import android.util.Log
import android.view.View

fun View.visible() = run { visibility = View.VISIBLE }

fun View.invisible() = run { visibility = View.INVISIBLE }

fun View.gone() = run { visibility = View.GONE }

infix fun View.visibleIf(condition: Boolean) =
    run { visibility = if (condition) View.VISIBLE else View.GONE }

infix fun View.invisibleIf(condition: Boolean) =
    run { visibility = if (condition) View.INVISIBLE else View.VISIBLE }

infix fun View.goneIf(condition: Boolean) =
    run { visibility = if (condition) View.GONE else View.VISIBLE }

fun Any?.printToLog(tag: String = "DEBUG_LOG") {
    Log.d(tag, toString())
}

const val TEXT = "Testing extension function"

fun testingExtensionFun(){
    TEXT.printToLog()
}

//isNull
val Any?.isNull get() = this ==  null
fun checkNull(){
//    if (obj.isNull){
//
//    }
//    else{
//
//    }
}