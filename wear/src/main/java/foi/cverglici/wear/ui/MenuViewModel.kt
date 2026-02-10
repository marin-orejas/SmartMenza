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

class MenuViewModel(application: Application) : AndroidViewModel(application) {

    private val menuStorage = MenuStorage(application)

    private val _menuItems = MutableStateFlow<List<WearMenuItem>>(emptyList())
    val menuItems: StateFlow<List<WearMenuItem>> = _menuItems.asStateFlow()

    init {
        loadMenuItems()
    }

    fun loadMenuItems() {
        viewModelScope.launch {
            _menuItems.value = menuStorage.getMenuItems()
        }
    }
}