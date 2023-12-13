package ac.id.ub.filkom.dugdugsehat.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    var email2: String by mutableStateOf("")
}
