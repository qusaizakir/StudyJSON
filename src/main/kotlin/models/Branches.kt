package models

data class Branches(
    val Id: String = "",
    val SourceFlowID: String = "",
    val TargetFlowId: String = "",
    val Conditions: List<Condition> = listOf(),
    val Order: Int = 0
)