package io.aristiyo.core.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams")
data class TeamEntity(
    @PrimaryKey
    @ColumnInfo(name = "id_team")
    val idTeam: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "name_alternate")
    val nameAlternate: String?,

    @ColumnInfo(name = "name_short")
    val nameShort: String?,

    @ColumnInfo(name = "formed_year")
    val formedYear: String?,

    @ColumnInfo(name = "league")
    val league: String?,

    @ColumnInfo(name = "id_league")
    val idLeague: String?,

    @ColumnInfo(name = "stadium")
    val stadium: String?,

    @ColumnInfo(name = "stadium_capacity")
    val stadiumCapacity: Int?,

    @ColumnInfo(name = "location")
    val location: String?,

    @ColumnInfo(name = "website")
    val website: String?,

    @ColumnInfo(name = "facebook")
    val facebook: String?,

    @ColumnInfo(name = "twitter")
    val twitter: String?,

    @ColumnInfo(name = "instagram")
    val instagram: String?,

    @ColumnInfo(name = "youtube")
    val youtube: String?,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "colour_primary")
    val colourPrimary: String?,

    @ColumnInfo(name = "colour_secondary")
    val colourSecondary: String?,

    @ColumnInfo(name = "colour_tertiary")
    val colourTertiary: String?,

    @ColumnInfo(name = "country")
    val country: String?,

    @ColumnInfo(name = "keywords")
    val keywords: String?,

    @ColumnInfo(name = "badge_url")
    val badgeUrl: String?,

    @ColumnInfo(name = "logo_url")
    val logoUrl: String?,

    @ColumnInfo(name = "fanart1_url")
    val fanart1Url: String?,

    @ColumnInfo(name = "fanart2_url")
    val fanart2Url: String?,

    @ColumnInfo(name = "fanart3_url")
    val fanart3Url: String?,

    @ColumnInfo(name = "fanart4_url")
    val fanart4Url: String?,

    @ColumnInfo(name = "banner_url")
    val bannerUrl: String?,

    @ColumnInfo(name = "equipment_url")
    val equipmentUrl: String?,

    @ColumnInfo(name = "is_favourite")
    var isFavourite: Boolean = false,
)