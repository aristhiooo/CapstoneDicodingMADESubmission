package io.aristiyo.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    val idTeam: String,
    val name: String,
    val nameAlternate: String?,
    val nameShort: String?,
    val formedYear: String?,
    val league: String?,
    val idLeague: String?,
    val stadium: String?,
    val stadiumCapacity: Int?,
    val location: String?,
    val website: String?,
    val facebook: String?,
    val twitter: String?,
    val instagram: String?,
    val youtube: String?,
    val description: String?,
    val colourPrimary: String?,
    val colourSecondary: String?,
    val colourTertiary: String?,
    val country: String?,
    val keywords: String?,
    val badgeUrl: String?,
    val logoUrl: String?,
    val fanartUrls: List<String>,
    val bannerUrl: String?,
    val equipmentUrl: String?,
    val isFavourite: Boolean,
) : Parcelable
