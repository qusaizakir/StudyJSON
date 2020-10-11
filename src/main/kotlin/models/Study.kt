package models

data class Study(
    val Id: String = "",
    val StudyInstanceId: String = "",
    val OrganisationId: String = "",
    val Environment: Int = 0,
    val OrganisationName: String = "",
    val Name: String = "",
    val Description: String = "",
    val ExcoIdentifier: String = "",
    val Protocol: String = "",
    val Formatting: String = "",
    val LastUpdated: String = "",
    val SiteTerminology: String = "",
    val SubjectTerminology: String = "",
    val Sites: List<Site> = listOf(),
    val JourneyGroups: List<JourneyGroup> = listOf(),
    val CapturePoints: List<Any> = listOf(),
    val Questionnaires: List<Questionnaire> = listOf()
)