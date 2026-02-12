package foi.cverglici.wear.data

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import foi.cverglici.core.data.model.wear.WearMenuItem

class MenuStorage(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val gson = Gson()

    fun saveMenuItems(items: List<WearMenuItem>) {
        val json = gson.toJson(items)
        prefs.edit()
            .putString(KEY_MENU_ITEMS, json)
            .putLong(KEY_LAST_UPDATE, System.currentTimeMillis())
            .commit()
    }

    fun getMenuItems(): List<WearMenuItem> {
        val json = prefs.getString(KEY_MENU_ITEMS, null) ?: return emptyList()
        return try {
            val type = object : TypeToken<List<WearMenuItem>>() {}.type
            gson.fromJson(json, type)
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun getLastUpdateTime(): Long {
        return prefs.getLong(KEY_LAST_UPDATE, 0L)
    }

    fun clearMenuItems() {
        prefs.edit()
            .remove(KEY_MENU_ITEMS)
            .remove(KEY_LAST_UPDATE)
            .apply()
    }

    companion object {
        private const val PREFS_NAME = "wear_menu_prefs"
        private const val KEY_MENU_ITEMS = "menu_items"
        private const val KEY_LAST_UPDATE = "last_update"
    }
}