package com.hmwn.cinemakmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform