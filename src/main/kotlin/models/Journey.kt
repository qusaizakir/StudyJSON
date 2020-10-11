package models

data class Journey(
    val Id: String = "",
    val Name: String = "",
    val NameTranslations: List<NameTranslation> = listOf(),
    val IsPublished: Boolean = false,
    val Availabilities: List<Any> = listOf()
)