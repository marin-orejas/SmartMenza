package foi.cverglici.core.data.model.wear

import foi.cverglici.core.data.model.student.dailymenu.DailyMenuItem

fun DailyMenuItem.toWearMenuItem(mealType: String): WearMenuItem {
    return WearMenuItem(
        title = dish.title,
        price = dish.price,
        description = dish.description,
        calories = dish.calories,
        mealType = mealType
    )
}