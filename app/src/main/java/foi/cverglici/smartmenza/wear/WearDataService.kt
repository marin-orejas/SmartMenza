package foi.cverglici.smartmenza.wear

import android.content.Context
import android.util.Log
import com.google.android.gms.tasks.Tasks
import com.google.android.gms.wearable.PutDataMapRequest
import com.google.android.gms.wearable.Wearable
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import foi.cverglici.core.data.model.wear.WearMenuItem

class WearDataService(private val context: Context) {

    private val dataClient by lazy { Wearable.getDataClient(context) }
    private val gson = Gson()
    suspend fun sendMenuItems(items: List<WearMenuItem>): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val json = gson.toJson(items)

                val request = PutDataMapRequest.create("/menu_items").apply {
                    dataMap.putLong("timestamp", System.currentTimeMillis())
                    dataMap.putString("items_json", json)
                }.asPutDataRequest()
                    .setUrgent()

                Tasks.await(dataClient.putDataItem(request))
                Log.d(TAG, "Successfully sent ${items.size} items to wear device")
                true
            } catch (e: Exception) {
                Log.e(TAG, "Failed to send data to wear device", e)
                false
            }
        }
    }

    companion object {
        private const val TAG = "WearDataService"
    }
}