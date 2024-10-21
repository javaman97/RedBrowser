package com.browser.red.domain.utils

fun String.extractBaseDomain(): String {
    return this
        .removePrefix("http://")
        .removePrefix("https://")
        .removePrefix("www.")
        .substringBefore("/")
        .substringBefore("?")
}
