package kib.dev.kibnews.tools

import kib.dev.kibnews.BuildConfig

// News Api Constants
const val NEWSAPI_BASE_URL = "http://newsapi.org/"
const val NEWSAPI_VERSION = "v2"
const val NEWSAPI_EP_TOPHEADLINES = "/top-headlines"
const val NEWSAPI_EP_EVERYTHING = "/everything"
const val NEWSAPI_EP_SOURCES = "/sources"
const val NEWSAPI_HEADER_KEY_APIKEY = "X-Api-Key"
const val NEWSAPI_HEADER_VALUE_APIKEY = BuildConfig.API_KEY_NEWSAPI
const val NEWSAPI_HEADER_KEY_ACCEPT = "Accept"
const val NEWSAPI_HEADER_VALUE_APPLICATION_JSON = "application/json"