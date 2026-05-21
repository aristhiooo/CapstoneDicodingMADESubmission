package io.aristiyo.core.source.local.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import io.aristiyo.core.source.local.entity.TeamEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(teams: List<TeamEntity>)

    @Query("SELECT * FROM teams ORDER BY name ASC")
    fun getAllTeams(): Flow<List<TeamEntity>>

    @Query("DELETE FROM teams")
    suspend fun deleteAll()

    @Query("SELECT * FROM teams where is_favourite = 1")
    fun getFavoriteTeams(): Flow<List<TeamEntity>>

    @Update
    suspend fun updateFavoriteTeam(team: TeamEntity)
}
