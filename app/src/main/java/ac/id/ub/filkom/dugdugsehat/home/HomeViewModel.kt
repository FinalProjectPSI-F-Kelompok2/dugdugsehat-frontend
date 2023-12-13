package ac.id.ub.filkom.dugdugsehat.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _polarIdState = MutableStateFlow("")
    val polarIdState: StateFlow<String> = _polarIdState

    fun setPolarId(polarId: String) {
        viewModelScope.launch {
            _polarIdState.emit(polarId)
        }
    }

    val visiblePermissionDialogQueue = mutableStateListOf<String>()

    fun dismissDialog() {
        visiblePermissionDialogQueue.removeLast()
    }

    fun onPermissionResult(
        permission: String,
        isGranted: Boolean
    ) {
        if (!isGranted) {
            visiblePermissionDialogQueue.add(0, permission)
        }
    }


}