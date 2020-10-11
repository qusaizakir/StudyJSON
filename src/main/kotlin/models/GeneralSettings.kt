package models

data class GeneralSettings(
    val MinLength: Any? = Any(),
    val MaxLength: Any? = Any(),
    val PlausibleLowerLimit: Any? = Any(),
    val PlausibleUpperLimit: Any? = Any(),
    val ControlTypeBehaviour: Int? = 0,
    val Orientation: Any? = Any(),
    val IsSimple: Boolean = false,
    val ShowScore: Boolean = false,
    val Precision: Int = 0,
    val ZeroPadded: Boolean = false
)