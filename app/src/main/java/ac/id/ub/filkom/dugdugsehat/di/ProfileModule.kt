package ac.id.ub.filkom.dugdugsehat.di

import android.os.Build
import androidx.annotation.RequiresExtension
import ac.id.ub.filkom.dugdugsehat.Api.RetrofitAPI
import ac.id.ub.filkom.dugdugsehat.data.repository.ProfileRepository
import ac.id.ub.filkom.dugdugsehat.data.repository.ProfileRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
object ProfileModule {

    @Provides
    @Singleton
    fun provideApi(): RetrofitAPI{
        return Retrofit.Builder()
            .baseUrl("https://dugdugsehat.anandadf.my.id/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideProfileRepository(
        api: RetrofitAPI
    ): ProfileRepository = ProfileRepositoryImpl(api)
}