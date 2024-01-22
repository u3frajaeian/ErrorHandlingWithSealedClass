package u3f.data.api

import io.filmtime.data.network.adapter.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import u3f.data.model.GeneralError
import u3f.data.model.Result
import u3f.data.model.User
import u3f.data.network.AppService
import javax.inject.Inject

class UsersRemoteSourceImpl @Inject constructor(private val appService: AppService) :
    UsersRemoteSource {
    override suspend fun getUsers(): Flow<Result<List<User>, GeneralError>> = flow {
        when (val result = appService.getUsers()) {

            is NetworkResponse.ApiError -> {
                val errorResponse = result.body
                emit(
                    Result.Failure(
                        GeneralError.ApiError(
                            errorResponse.statusMessage,
                            errorResponse.statusCode
                        )
                    )
                )


            }

            is NetworkResponse.NetworkError -> {
                emit(Result.Failure(GeneralError.NetworkError))
            }

            is NetworkResponse.Success -> {
                val userResponse = result.body
                if (userResponse == null) {
                    emit(Result.Failure(GeneralError.UnknownError(Throwable("User Response is null"))))
                } else {
                    emit(Result.Success(userResponse.map { it.toUser() }))
                }
            }

            is NetworkResponse.UnknownError -> {
                emit(Result.Failure(GeneralError.UnknownError(result.error)))
            }
        }
    }


}