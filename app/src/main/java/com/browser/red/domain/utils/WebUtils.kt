package com.browser.red.domain.utils
object WebUtils{
    const val DEFAULT_URL = "https://www.google.com"
}
fun String.extractBaseDomain(): String {
    return this
        .removePrefix("http://")
        .removePrefix("https://")
        .removePrefix("www.")
        .substringBefore("/")
        .substringBefore("?")
}
