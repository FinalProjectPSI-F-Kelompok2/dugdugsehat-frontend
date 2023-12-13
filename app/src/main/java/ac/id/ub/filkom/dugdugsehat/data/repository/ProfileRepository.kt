package ac.id.ub.filkom.dugdugsehat.data.repository

import ac.id.ub.filkom.dugdugsehat.Model.DataModel
import ac.id.ub.filkom.dugdugsehat.Model.ProfileResponse
import ac.id.ub.filkom.dugdugsehat.util.Resource
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    suspend fun getDataUsingRetrofit(email: String): Flow<Resource<ProfileResponse>>
    suspend fun updateProfile(
        dataModel: DataModel
    ): Flow<Resource<Unit>>

}