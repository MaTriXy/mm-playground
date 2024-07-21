package com.elkriefy.playground

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform