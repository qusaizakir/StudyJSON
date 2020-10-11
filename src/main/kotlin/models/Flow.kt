package models

data class Flow(
    val Id: String = "",
    val PublishedQuestionnaireId: String = "",
    val FlowSteps: List<FlowStep> = listOf()
)