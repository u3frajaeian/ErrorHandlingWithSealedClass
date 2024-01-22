package u3f.data.users

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserListModule {
    @Binds
    abstract fun bindUserListRepository(impl: UserListRepositoryImpl):UserListRepository
}