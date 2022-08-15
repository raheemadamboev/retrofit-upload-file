package xyz.teamgravity.retrofitfileupload.injection.provide

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import xyz.teamgravity.retrofitfileupload.core.util.RonaldoProvider
import xyz.teamgravity.retrofitfileupload.data.remote.api.FileApi
import xyz.teamgravity.retrofitfileupload.data.remote.constant.FileApiConst
import xyz.teamgravity.retrofitfileupload.data.repository.FileRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideFileApi(): FileApi = Retrofit.Builder()
        .baseUrl(FileApiConst.BASE_URL)
        .build()
        .create(FileApi::class.java)

    @Provides
    @Singleton
    fun provideFileRepository(fileApi: FileApi): FileRepository = FileRepository(fileApi)

    @Provides
    @Singleton
    fun provideRonaldoProvider(application: Application): RonaldoProvider = RonaldoProvider(application)
}