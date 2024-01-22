package u3f.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("login")
    val login: String? = null,
    @SerialName("id")
    val id: Long? = null,

    @SerialName("node_id")
    val nodeID: String? = null,

    @SerialName("avatar_url")
    val avatarURL: String? = null,

    @SerialName("gravatar_id")
    val gravatarID: String? = null,

    @SerialName("url")
    val url: String? = null,

    @SerialName("html_url")
    val htmlURL: String? = null,

    @SerialName("followers_url")
    val followersURL: String? = null,

    @SerialName("following_url")
    val followingURL: String? = null,

    @SerialName("gists_url")
    val gistsURL: String? = null,

    @SerialName("starred_url")
    val starredURL: String? = null,

    @SerialName("subscriptions_url")
    val subscriptionsURL: String? = null,

    @SerialName("organizations_url")
    val organizationsURL: String? = null,

    @SerialName("repos_url")
    val reposURL: String? = null,

    @SerialName("events_url")
    val eventsURL: String? = null,

    @SerialName("received_events_url")
    val receivedEventsURL: String? = null,

    @SerialName("type")
    val type: String? = null,

    @SerialName("site_admin")
    val siteAdmin: Boolean? = null
)
