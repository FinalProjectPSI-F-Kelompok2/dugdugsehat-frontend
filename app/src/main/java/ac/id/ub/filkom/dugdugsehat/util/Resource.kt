package ac.id.ub.filkom.dugdugsehat.util

sealed class Resource<T>(val data: T? = null, val uiText: String? = null) {
    class Loading<T>(data: T? = null) : Resource<T>()
    class Error<T>(uiText: String? = null, data: T? = null) : Resource<T>(data, uiText)
    class Success<T>(data: T?) : Resource<T>(data)
}
