package u3f.data.users

import kotlinx.coroutines.flow.Flow
import u3f.data.api.UsersRemoteSource
import u3f.data.model.GeneralError
import u3f.data.model.Result
import u3f.data.model.User
import javax.inject.Inject

class UserListRepositoryImpl @Inject constructor(private val usersRemoteSource: UsersRemoteSource) :
    UserListRepository {
    override suspend fun getUsers(): Flow<Result<List<User>, GeneralError>> =
        usersRemoteSource.getUsers()

}