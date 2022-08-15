package xyz.teamgravity.retrofitfileupload.data.remote.api

import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.Part

interface FileApi {

    ///////////////////////////////////////////////////////////////////////////
    // UPLOAD
    ///////////////////////////////////////////////////////////////////////////

    @Multipart
    suspend fun uploadImage(
        @Part image: MultipartBody.Part,
    )
}