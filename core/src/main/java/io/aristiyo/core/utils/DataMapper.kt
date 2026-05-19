package io.aristiyo.core.utils

import io.aristiyo.core.domain.model.Team
import io.aristiyo.core.source.local.entity.TeamEntity
import io.aristiyo.core.source.remote.response.TeamDto

fun TeamDto.toEntity(): TeamEntity {
    return TeamEntity(
        idTeam = idTeam.orEmpty(),
        name = strTeam.orEmpty(),
        nameAlternate = strTeamAlternate,
        nameShort = strTeamShort,
        formedYear = intFormedYear,
        league = strLeague,
        idLeague = idLeague,
        stadium = strStadium,
        stadiumCapacity = intStadiumCapacity?.toIntOrNull(),
        location = strLocation,
        website = strWebsite,
        facebook = strFacebook,
        twitter = strTwitter,
        instagram = strInstagram,
        youtube = strYoutube,
        description = strDescriptionEN,
        colourPrimary = strColour1,
        colourSecondary = strColour2,
        colourTertiary = strColour3,
        country = strCountry,
        keywords = strKeywords,
        badgeUrl = strBadge,
        logoUrl = strLogo,
        fanart1Url = strFanart1,
        fanart2Url = strFanart2,
        fanart3Url = strFanart3,
        fanart4Url = strFanart4,
        bannerUrl = strBanner,
        equipmentUrl = strEquipment,
        isFavourite = false,
    )
}

fun List<TeamDto>.toEntityList(): List<TeamEntity> = map { it.toEntity() }

fun TeamEntity.toDomain(): Team {
    return Team(
        idTeam = idTeam,
        name = name,
        nameAlternate = nameAlternate,
        nameShort = nameShort,
        formedYear = formedYear,
        league = league,
        idLeague = idLeague,
        stadium = stadium,
        stadiumCapacity = stadiumCapacity,
        location = location,
        website = website,
        facebook = facebook,
        twitter = twitter,
        instagram = instagram,
        youtube = youtube,
        description = description,
        colourPrimary = colourPrimary,
        colourSecondary = colourSecondary,
        colourTertiary = colourTertiary,
        country = country,
        keywords = keywords,
        badgeUrl = badgeUrl,
        logoUrl = logoUrl,
        fanartUrls = listOfNotNull(fanart1Url, fanart2Url, fanart3Url, fanart4Url),
        bannerUrl = bannerUrl,
        equipmentUrl = equipmentUrl,
        isFavourite = isFavourite,
    )
}

fun List<TeamEntity>.toDomainList(): List<Team> = map { it.toDomain() }

fun Team.toEntity(): TeamEntity {
    return TeamEntity(
        idTeam = idTeam,
        name = name,
        nameAlternate = nameAlternate,
        nameShort = nameShort,
        formedYear = formedYear,
        league = league,
        idLeague = idLeague,
        stadium = stadium,
        stadiumCapacity = stadiumCapacity,
        location = location,
        website = website,
        facebook = facebook,
        twitter = twitter,
        instagram = instagram,
        youtube = youtube,
        description = description,
        colourPrimary = colourPrimary,
        colourSecondary = colourSecondary,
        colourTertiary = colourTertiary,
        country = country,
        keywords = keywords,
        badgeUrl = badgeUrl,
        logoUrl = logoUrl,
        fanart1Url = fanartUrls.getOrNull(0),
        fanart2Url = fanartUrls.getOrNull(1),
        fanart3Url = fanartUrls.getOrNull(2),
        fanart4Url = fanartUrls.getOrNull(3),
        bannerUrl = bannerUrl,
        equipmentUrl = equipmentUrl,
        isFavourite = isFavourite,
    )
}
