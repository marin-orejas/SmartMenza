package foi.cverglici.core.data.model.wear

data class WearMenuItem(
    val title: String,
    val price: Double,
    val description: String?,
    val calories: Int,
    val mealType: String
)