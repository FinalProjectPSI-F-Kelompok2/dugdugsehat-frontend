package ac.id.ub.filkom.dugdugsehat.network

import ac.id.ub.filkom.dugdugsehat.Model.LoginRequest
import ac.id.ub.filkom.dugdugsehat.Model.LoginResponse
import ac.id.ub.filkom.dugdugsehat.Model.RegisterRequest
import ac.id.ub.filkom.dugdugsehat.Model.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitAPI {
    @POST("login")
    fun login(@Body loginRequest: LoginRequest?): Call<LoginResponse?>?
    @POST("register")
    fun register(@Body registerRequest: RegisterRequest?): Call<RegisterResponse?>?
}