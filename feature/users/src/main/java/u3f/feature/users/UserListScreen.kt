package u3f.feature.users

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import u3f.data.model.User

@Composable
fun UserListScreen(viewModel: UserListViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Box {
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.wrapContentSize().align(Alignment.Center))

        } else if (state.error != null) {
            Text(text = state.error.orEmpty())
        } else {
            LazyColumn {
                items(state.users) { user ->
                    UserItem(user)
                }
            }
        }

    }

}

@Composable
fun UserItem(user: User) {
    Row (modifier=Modifier.padding(6.dp),
        verticalAlignment = Alignment.CenterVertically){
        AsyncImage(
            model = user.avatarURL, contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape).size(50.dp)
        )

        Text(text = user.login, modifier = Modifier.padding(horizontal = 8.dp))
    }
}