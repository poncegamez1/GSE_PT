package com.example.gse_pt.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gse_pt.model.Users
import com.example.gse_pt.repository.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: UsersRepository,
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) : ViewModel() {

    private var userState: MutableLiveData<List<Users>> = MutableLiveData<List<Users>>()
    val onUserState: LiveData<List<Users>> get() = userState

    fun getUsersFromServer(){
        viewModelScope.launch(coroutineContext) {
            userState.postValue(repository.getAllUsers())
        }
    }
}