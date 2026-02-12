package foi.cverglici.smartmenza.wear

import android.content.Context
import android.util.Log
import com.google.android.gms.wearable.PutDataMapRequest
import com.google.android.gms.wearable.Wearable
import com.google.gson.Gson
import foi.cverglici.core.data.model.wear.WearMenuItem

class MenuSyncManager(
    private val context: Context,
    private val gson: Gson = Gson()
) {

    fun syncMenuToWatch(items: List<WearMenuItem>) {
        val json = gson.toJson(items)
        Log.i("SALJEM", json)

        val request = PutDataMapRequest.create("/menu_items").apply {
            dataMap.putString("items_json", json)
            dataMap.putLong("timestamp", System.currentTimeMillis())
        }
            .asPutDataRequest()
            .setUrgent()

        val dataClient = Wearable.getDataClient(context)
        dataClient.putDataItem(request)
    }
}