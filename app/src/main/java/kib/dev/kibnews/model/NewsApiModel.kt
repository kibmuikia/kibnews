package kib.dev.kibnews.model

/*
*
* {

    "status": "ok",
    "totalResults": 38,
    -
    "articles": [
        -
        {
            -
            "source": {
                "id": "cnn",
                "name": "CNN"
            },
            "author": "Yoonjung Seo, Gawon Bae and Joshua Berlinger, CNN",
            "title": "North Korean hackers stole Covid-19 data from Pfizer, South Korean lawmaker says - CNN",
            "description": "Did North Korea hack US drugmaker Pfizer and steal data on Covid-19 vaccines and treatment research? The answer, at least on Wednesday in South Korea, depends on who you ask.",
            "url": "https://www.cnn.com/2021/02/17/asia/north-korea-pfizer-intl-hnk/index.html",
            "urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/210114205246-03-north-korea-military-parade-super-tease.jpg",
            "publishedAt": "2021-02-17T08:29:00Z",
            "content": "Seoul, South Korea (CNN)Did North Korea hack US drugmaker Pfizer and steal data on Covid-19 vaccines and treatment research? The answer, at least on Wednesday in South Korea, depends on who you ask.\r… [+7233 chars]"
        },
        -
        {
            -
            "source": {
                "id": "bloomberg",
                "name": "Bloomberg"
            },
            "author": null,
            "title": "Bitcoin (BTC USD) Cryptocurrency Price Jumps to All-Time High - Bloomberg",
            "description": null,
            "url": "https://www.bloomberg.com/tosv2.html?vid=&uuid=39884c90-70fe-11eb-b60c-db60966ff098&url=L25ld3MvYXJ0aWNsZXMvMjAyMS0wMi0xNy9iaXRjb2luLWp1bXBzLXRvLWFsbC10aW1lLWhpZ2gtYXMtY3J5cHRvY3VycmVuY3ktZmV2ZXItY29udGludWVz",
            "urlToImage": null,
            "publishedAt": "2021-02-17T07:21:00Z",
            "content": "To continue, please click the box below to let us know you're not a robot."
        },
*
* */

data class Source(
    val id: String?,
    val name: String?,
)

data class Article(
    val source: Source,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
)

data class NewsApiResponse(
    val status: String?,
    val totalResults: Int?,
    val articles: List<Article>?,
)