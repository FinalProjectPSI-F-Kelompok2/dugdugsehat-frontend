package ac.id.ub.filkom.dugdugsehat.data.repository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import ac.id.ub.filkom.dugdugsehat.Api.RetrofitAPI
import ac.id.ub.filkom.dugdugsehat.Model.DataModel
import ac.id.ub.filkom.dugdugsehat.Model.ProfileRequest
import ac.id.ub.filkom.dugdugsehat.Model.ProfileResponse
import ac.id.ub.filkom.dugdugsehat.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class ProfileRepositoryImpl @Inject constructor(
    private val api: RetrofitAPI
) : ProfileRepository {

    override suspend fun getDataUsingRetrofit(
        email: String
    ): Flow<Resource<ProfileResponse>> = flow {
        emit(Resource.Loading())

        try {
            val request = ProfileRequest(email)
            val result = api.getdata(request)
            emit(Resource.Success(result))
        } catch (e: HttpException) {
            emit(Resource.Error(e.toString()))
        } catch (e: IOException) {
            emit(Resource.Error(e.toString()))
        } catch (e: Exception) {
            emit(Resource.Error(e.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun updateProfile(
        dataModel: DataModel
    ): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())

            try {
                val result = api.postData(dataModel)
                emit(Resource.Success(Unit))
            } catch (e: HttpException) {
                emit(Resource.Error(e.toString()))
            } catch (e: IOException) {
                emit(Resource.Error(e.toString()))
            } catch (e: Exception) {
                emit(Resource.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}