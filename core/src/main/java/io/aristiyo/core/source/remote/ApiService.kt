package io.aristiyo.core.source.remote

import io.aristiyo.core.source.remote.response.TeamsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/v1/json/123/search_all_teams.php")
    suspend fun getTeamsList(
        @Query("l") leagueName: String = "English_Premier_League",
    ): TeamsResponse
}
