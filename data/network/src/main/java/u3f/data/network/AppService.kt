package u3f.data.network

import io.filmtime.data.network.adapter.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppService {

    @GET("users")
    suspend fun getUsers(): NetworkResponse<List<UserResponse>, ErrorResponse>

}
