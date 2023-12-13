package ac.id.ub.filkom.dugdugsehat.Api

import ac.id.ub.filkom.dugdugsehat.Model.DataModel
import ac.id.ub.filkom.dugdugsehat.Model.ProfileRequest
import ac.id.ub.filkom.dugdugsehat.Model.ProfileResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitAPI {
    @POST("profile/update")
    suspend fun postData(@Body dataModel: DataModel?): DataModel


    @POST("profile/get")
    suspend fun getdata(@Body profileRequest: ProfileRequest?): ProfileResponse
}