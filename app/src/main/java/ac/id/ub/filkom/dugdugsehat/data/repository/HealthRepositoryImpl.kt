package ac.id.ub.filkom.dugdugsehat.data.repository

import ac.id.ub.filkom.dugdugsehat.Api.RetrofitAPI
import ac.id.ub.filkom.dugdugsehat.Model.HealthRequest
import ac.id.ub.filkom.dugdugsehat.Model.HealthResponse
import ac.id.ub.filkom.dugdugsehat.util.Resource
import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class HealthRepositoryImpl @Inject constructor(
    private val api: RetrofitAPI
) : HealthRepository {
    override suspend fun getDataUsingRetrofit(
        email: String,
        row: String
    ): Flow<Resource<HealthResponse>> = flow {
        emit(Resource.Loading())

        try {
            val request = HealthRequest(email, row)
            val result = api.getHealthData(request)
            emit(Resource.Success(result))
        } catch (e: HttpException) {
            emit(Resource.Error(e.toString()))
        } catch (e: IOException) {
            emit(Resource.Error(e.toString()))
        } catch (e: Exception) {
            emit(Resource.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)
}