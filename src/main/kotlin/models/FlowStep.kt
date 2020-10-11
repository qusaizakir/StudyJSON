package models

data class FlowStep(
    val Id: String = "",
    val FlowId: String = "",
    val ParentFlowStepId: Any? = Any(),
    val Order: Int = 0,
    val Page: Page = Page(),
    val branches: List<Branches> = listOf()
)