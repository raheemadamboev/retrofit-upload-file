package xyz.teamgravity.retrofitfileupload.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import xyz.teamgravity.retrofitfileupload.R
import xyz.teamgravity.retrofitfileupload.presentation.viewmodel.ImageUploadViewModel

@Composable
fun ImageUploadScreen(
    viewmodel: ImageUploadViewModel = hiltViewModel(),
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(onClick = viewmodel::onUpload) {
            Text(text = stringResource(id = R.string.upload_image))
        }
    }
}