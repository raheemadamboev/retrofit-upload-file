package xyz.teamgravity.retrofitfileupload.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import xyz.teamgravity.retrofitfileupload.core.util.RonaldoProvider
import xyz.teamgravity.retrofitfileupload.data.repository.FileRepository
import javax.inject.Inject

@HiltViewModel
class ImageUploadViewModel @Inject constructor(
    private val repository: FileRepository,
    private val ronaldo: RonaldoProvider,
) : ViewModel() {

    fun onUpload() {
        viewModelScope.launch {
            repository.uploadImage(ronaldo.provide())
        }
    }
}