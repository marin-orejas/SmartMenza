package foi.cverglici.wear.service

import android.util.Log
import com.google.android.gms.wearable.DataEvent
import com.google.android.gms.wearable.DataEventBuffer
import com.google.android.gms.wearable.DataMapItem
import com.google.android.gms.wearable.WearableListenerService
import foi.cverglici.wear.model.WearMenuItem

class WearDataListenerService : WearableListenerService() {

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
        val dataMap = DataMapItem.fromDataItem(event.dataItem).dataMap
        val itemsRaw = dataMap.getStringArrayList("items") ?: return

        val items = itemsRaw.mapNotNull { raw ->
            val parts = raw.split("|")
            if (parts.size == 4) {
                WearMenuItem(
                    title = parts[0],
                    price = parts[1].toDoubleOrNull() ?: return@mapNotNull null,
                    description = parts[2].ifEmpty { null },
                    calories = parts[3].toIntOrNull() ?: return@mapNotNull null
                )
            } else null
        }

        Log.d(TAG, "Received ${items.size} menu items from phone")
    }

    companion object {
        private const val TAG = "WearDataListener"
    }
}