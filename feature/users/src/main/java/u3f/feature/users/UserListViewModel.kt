package u3f.feature.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import u3f.data.model.GeneralError
import u3f.data.model.Result
import u3f.data.users.UserListRepository
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(private val userListRepository: UserListRepository) :
    ViewModel() {
    private val _state = MutableStateFlow(UserListState())
    val state = _state.asStateFlow()

    init {
        loadUser()
    }

    fun loadUser() = viewModelScope.launch {
        _state.value = state.value.copy(isLoading = true)
        userListRepository.getUsers().onEach { result ->
            when (result) {
                is Result.Failure -> {
                    val message = when (result.error) {
                        is GeneralError.ApiError -> "Api Error"
                        GeneralError.NetworkError -> "Network Error"
                        is GeneralError.UnknownError -> "Please try again later!"
                    }
                    _state.value =
                        state.value.copy(isLoading = false, error = message)

                }

                is Result.Success -> _state.value =
                    state.value.copy(isLoading = false, users = result.data)
            }

        }.collect()
    }
}