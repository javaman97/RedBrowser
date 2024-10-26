package com.browser.red.domain.utils
object WebUtils{
    const val DEFAULT_URL = "new_tab"
}
fun String.extractBaseDomain(): String {
    return this
        .removePrefix("http://")
        .removePrefix("https://")
        .removePrefix("www.")
        .substringBefore("/")
        .substringBefore("?")
}
