package foi.cverglici.wear.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import foi.cverglici.core.data.model.wear.WearMenuItem
import foi.cverglici.wear.data.MenuStorage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import android.annotation.SuppressLint
import foi.cverglici.wear.sync.WearMenuSync
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build

class MenuViewModel(application: Application) : AndroidViewModel(application) {

    private val menuStorage = MenuStorage(application)

    private val _menuItems = MutableStateFlow<List<WearMenuItem>>(emptyList())
    val menuItems: StateFlow<List<WearMenuItem>> = _menuItems.asStateFlow()

    private val updateReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == WearMenuSync.ACTION_MENU_UPDATED) {
                loadMenuItems()
            }
        }
    }

    init {
        loadMenuItems()
        registerUpdateReceiver()
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    private fun registerUpdateReceiver() {
        val filter = IntentFilter(WearMenuSync.ACTION_MENU_UPDATED)
        val app = getApplication<Application>()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            app.registerReceiver(
                updateReceiver,
                filter,
                Context.RECEIVER_NOT_EXPORTED
            )
        } else {
            app.registerReceiver(updateReceiver, filter)
        }
    }

    fun loadMenuItems() {
        viewModelScope.launch {
            _menuItems.value = menuStorage.getMenuItems()
        }
    }

    override fun onCleared() {
        super.onCleared()
        getApplication<Application>().unregisterReceiver(updateReceiver)
    }
}