package u3f.data.api

import kotlinx.coroutines.flow.Flow
import u3f.data.model.GeneralError
import u3f.data.model.Result
import u3f.data.model.User


interface UsersRemoteSource {

    suspend fun getUsers(): Flow<Result<List<User>, GeneralError>>


}
