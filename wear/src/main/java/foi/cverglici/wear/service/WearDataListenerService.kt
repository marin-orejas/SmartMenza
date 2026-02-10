package foi.cverglici.wear.service

import android.util.Log
import com.google.android.gms.wearable.DataEvent
import com.google.android.gms.wearable.DataEventBuffer
import com.google.android.gms.wearable.DataMapItem
import com.google.android.gms.wearable.WearableListenerService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import foi.cverglici.core.data.model.wear.WearMenuItem
import foi.cverglici.wear.data.MenuStorage

class WearDataListenerService : WearableListenerService() {

    private val menuStorage by lazy { MenuStorage(applicationContext) }
    private val gson = Gson()

    override fun onDataChanged(dataEvents: DataEventBuffer) {
        dataEvents.forEach { event ->
            if (event.type == DataEvent.TYPE_CHANGED) {
                when (event.dataItem.uri.path) {
                    "/menu_items" -> handleMenuItems(event)
                }
            }
        }
    }

    private fun handleMenuItems(event: DataEvent) {
        try {
            val dataMap = DataMapItem.fromDataItem(event.dataItem).dataMap

            val json = dataMap.getString("items_json") ?: return

            val type = object : TypeToken<List<WearMenuItem>>() {}.type
            val items: List<WearMenuItem> = gson.fromJson(json, type)

            menuStorage.saveMenuItems(items)
            Log.d(TAG, "Received and saved ${items.size} menu items from phone")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to parse menu items", e)
        }
    }

    companion object {
        private const val TAG = "WearDataListener"
    }
}