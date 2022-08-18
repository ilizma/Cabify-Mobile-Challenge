object Environments {

    data class Environment(
        val baseURL: String = "",
    )

    val release = Environment(
        baseURL = "https://gist.githubusercontent.com/",
    )
    val debug = Environment(
        baseURL = "https://gist.githubusercontent.com/",
    )

}