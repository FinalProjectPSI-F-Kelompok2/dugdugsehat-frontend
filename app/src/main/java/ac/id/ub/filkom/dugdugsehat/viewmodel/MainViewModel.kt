package ac.id.ub.filkom.dugdugsehat.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ac.id.ub.filkom.dugdugsehat.Model.DataModel
import ac.id.ub.filkom.dugdugsehat.Model.HealthProfile
import ac.id.ub.filkom.dugdugsehat.Model.ProfileResponse
import ac.id.ub.filkom.dugdugsehat.Model.User
import ac.id.ub.filkom.dugdugsehat.data.repository.ProfileRepository
import ac.id.ub.filkom.dugdugsehat.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ProfileRepository
) : ViewModel() {
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _user = mutableStateOf(ProfileResponse())
    val user: State<ProfileResponse?> = _user

    fun getUser(email: String) {
        viewModelScope.launch {
            repository.getDataUsingRetrofit(email).collect { result ->
                when (result) {
                    is Resource.Error -> {
                        _isLoading.value = false
                        println("ERROR PROFILE")
                    }

                    is Resource.Loading -> {
                        _isLoading.value = true
                    }

                    is Resource.Success -> {
                        _isLoading.value = false
                        _user.value = result.data!!
                        println("SUKSES ${result.data.user?.email}")
                    }
                }
            }
        }
    }

    fun updateProfile(
        name: String,
        email: String,
        password: String,
        age: Int,
        gender: Boolean,
        height: Int,
        weight: Int,
    ) {
        val request = DataModel(
            User(
                name,
                email,
                password
            ),
            HealthProfile(
                gender,
                age,
                height,
                weight
            )
        )
        viewModelScope.launch {
            repository.updateProfile(dataModel = request).collect { result ->
                when (result) {
                    is Resource.Error -> {
                        _isLoading.value = false
                        println("ERROR PROFILE")
                    }

                    is Resource.Loading -> {
                        _isLoading.value = true
                    }

                    is Resource.Success -> {
                        _isLoading.value = false
                    }
                }
            }
        }
    }
}