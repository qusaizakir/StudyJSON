package models

data class Page(
    val Id: String = "",
    val Name: String = "",
    val Description: Any? = Any(),
    val Questions: List<Question> = listOf(),
    val PageGlobalIdentifier: String = ""
)