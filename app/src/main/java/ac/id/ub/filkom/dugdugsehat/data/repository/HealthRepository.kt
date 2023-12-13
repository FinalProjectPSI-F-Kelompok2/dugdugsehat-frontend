package ac.id.ub.filkom.dugdugsehat.data.repository

import ac.id.ub.filkom.dugdugsehat.Model.HealthResponse
import ac.id.ub.filkom.dugdugsehat.util.Resource
import kotlinx.coroutines.flow.Flow

interface HealthRepository {
    suspend fun getDataUsingRetrofit(email: String, row: String): Flow<Resource<HealthResponse>>
}