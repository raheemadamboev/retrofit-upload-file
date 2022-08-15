package xyz.teamgravity.retrofitfileupload.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException
import xyz.teamgravity.retrofitfileupload.data.remote.api.FileApi
import xyz.teamgravity.retrofitfileupload.data.remote.constant.FileApiConst
import java.io.File
import java.io.IOException

class FileRepository(
    private val api: FileApi,
) {

    ///////////////////////////////////////////////////////////////////////////
    // UPLOAD
    ///////////////////////////////////////////////////////////////////////////

    suspend fun uploadImage(file: File): Boolean {
        return withContext(Dispatchers.IO) {
            return@withContext try {
                api.uploadImage(
                    MultipartBody.Part.createFormData(
                        FileApiConst.TYPE_IMAGE,
                        file.name,
                        file.asRequestBody()
                    )
                )
                true
            } catch (e: HttpException) {
                false
            } catch (e: IOException) {
                false
            }
        }
    }
}