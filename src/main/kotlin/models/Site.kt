package models

data class Site(
    val Id: String = "",
    val Languages: List<Language> = listOf(),
    val SiteCode: String = "",
    val IsSiteApprovedForEnrolment: Boolean = false
)