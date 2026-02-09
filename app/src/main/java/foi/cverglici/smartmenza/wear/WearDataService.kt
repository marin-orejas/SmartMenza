package foi.cverglici.smartmenza.wear

import android.content.Context
import android.util.Log
import com.google.android.gms.tasks.Tasks
import com.google.android.gms.wearable.PutDataMapRequest
import com.google.android.gms.wearable.Wearable

class WearDataService(private val context: Context) {

    private val dataClient by lazy { Wearable.getDataClient(context) }

    fun sendMenuItems(items: List<SimpleMenuItem>): Boolean {
        return try {
            val serializedItems = items.map { item ->
                "${item.id}|${item.name}|${item.category}"
            }

            val request = PutDataMapRequest.create("/menu_items").apply {
                dataMap.putLong("timestamp", System.currentTimeMillis())
                dataMap.putStringArrayList("items", ArrayList(serializedItems))
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

    data class SimpleMenuItem(
        val id: Int,
        val name: String,
        val category: String
    )

    companion object {
        private const val TAG = "WearDataService"
    }
}