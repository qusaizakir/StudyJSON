package models.events

data class Event(
    val Id: String = "",
    val EventGlobalIdentifier: String = "",
    val Name: String = "",
    val TimelineDateTime: String = "",
    val Type: Int = 0,
    val IsVisibleOnExternalUI: Boolean = false,
    val IsSiteVisit: Boolean = false
)