package foi.cverglici.smartmenza.wear

import android.content.Context
import android.util.Log
import com.google.android.gms.tasks.Tasks
import com.google.android.gms.wearable.PutDataMapRequest
import com.google.android.gms.wearable.Wearable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WearDataService(private val context: Context) {

    private val dataClient by lazy { Wearable.getDataClient(context) }

    suspend fun sendMenuItems(items: List<WearMenuItem>): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val serializedItems = items.map { item ->
                    "${item.title}|${item.price}|${item.description ?: ""}|${item.calories}"
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
    }

    data class WearMenuItem(
        val title: String,
        val price: Double,
        val description: String?,
        val calories: Int
    )

    companion object {
        private const val TAG = "WearDataService"
    }
}