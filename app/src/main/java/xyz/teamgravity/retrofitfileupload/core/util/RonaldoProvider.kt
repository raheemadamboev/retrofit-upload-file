package xyz.teamgravity.retrofitfileupload.core.util

import android.app.Application
import java.io.File

class RonaldoProvider(
    private val application: Application,
) {

    fun provide(): File {
        val file = File(application.cacheDir, "ronaldo.jpeg")
        file.createNewFile()
        file.outputStream().use { stream ->
            application.assets.open("image/ronaldo.jpeg").copyTo(stream)
        }
        return file
    }
}