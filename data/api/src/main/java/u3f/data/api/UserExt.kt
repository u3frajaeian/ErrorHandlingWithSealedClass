package u3f.data.api

import u3f.data.model.User
import u3f.data.network.UserResponse

fun UserResponse.toUser() = User(
    login = login.orEmpty(),
    id = id ?: 0,
    avatarURL = avatarURL.orEmpty(),
    )