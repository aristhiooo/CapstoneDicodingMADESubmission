package io.aristiyo.core.source.remote.response

import com.google.gson.annotations.SerializedName

data class TeamsResponse(
    @SerializedName("teams")
    val teams: List<TeamDto>?,
)

data class TeamDto(
    @SerializedName("idTeam")
    val idTeam: String?,
    @SerializedName("idESPN")
    val idEspn: String?,
    @SerializedName("idAPIfootball")
    val idApiFootball: String?,
    @SerializedName("intLoved")
    val intLoved: String?,
    @SerializedName("strTeam")
    val strTeam: String?,
    @SerializedName("strTeamAlternate")
    val strTeamAlternate: String?,
    @SerializedName("strTeamShort")
    val strTeamShort: String?,
    @SerializedName("intFormedYear")
    val intFormedYear: String?,
    @SerializedName("strSport")
    val strSport: String?,
    @SerializedName("strGender")
    val strGender: String?,
    @SerializedName("strCountry")
    val strCountry: String?,
    @SerializedName("strKeywords")
    val strKeywords: String?,
    @SerializedName("strLocked")
    val strLocked: String?,
    @SerializedName("idLeague")
    val idLeague: String?,
    @SerializedName("strLeague")
    val strLeague: String?,
    @SerializedName("idLeague2")
    val idLeague2: String?,
    @SerializedName("strLeague2")
    val strLeague2: String?,
    @SerializedName("idLeague3")
    val idLeague3: String?,
    @SerializedName("strLeague3")
    val strLeague3: String?,
    @SerializedName("idLeague4")
    val idLeague4: String?,
    @SerializedName("strLeague4")
    val strLeague4: String?,
    @SerializedName("idLeague5")
    val idLeague5: String?,
    @SerializedName("strLeague5")
    val strLeague5: String?,
    @SerializedName("idLeague6")
    val idLeague6: String?,
    @SerializedName("strLeague6")
    val strLeague6: String?,
    @SerializedName("idLeague7")
    val idLeague7: String?,
    @SerializedName("strLeague7")
    val strLeague7: String?,
    @SerializedName("strDivision")
    val strDivision: String?,
    @SerializedName("idVenue")
    val idVenue: String?,
    @SerializedName("strStadium")
    val strStadium: String?,
    @SerializedName("strLocation")
    val strLocation: String?,
    @SerializedName("intStadiumCapacity")
    val intStadiumCapacity: String?,
    @SerializedName("strWebsite")
    val strWebsite: String?,
    @SerializedName("strFacebook")
    val strFacebook: String?,
    @SerializedName("strTwitter")
    val strTwitter: String?,
    @SerializedName("strInstagram")
    val strInstagram: String?,
    @SerializedName("strYoutube")
    val strYoutube: String?,
    @SerializedName("strRSS")
    val strRss: String?,
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String?,
    @SerializedName("strDescriptionDE")
    val strDescriptionDE: String?,
    @SerializedName("strDescriptionFR")
    val strDescriptionFR: String?,
    @SerializedName("strDescriptionIT")
    val strDescriptionIT: String?,
    @SerializedName("strDescriptionES")
    val strDescriptionES: String?,
    @SerializedName("strDescriptionPT")
    val strDescriptionPT: String?,
    @SerializedName("strDescriptionJP")
    val strDescriptionJP: String?,
    @SerializedName("strDescriptionRU")
    val strDescriptionRU: String?,
    @SerializedName("strDescriptionNO")
    val strDescriptionNO: String?,
    @SerializedName("strDescriptionCN")
    val strDescriptionCN: String?,
    @SerializedName("strDescriptionSE")
    val strDescriptionSE: String?,
    @SerializedName("strDescriptionNL")
    val strDescriptionNL: String?,
    @SerializedName("strDescriptionHU")
    val strDescriptionHU: String?,
    @SerializedName("strDescriptionIL")
    val strDescriptionIL: String?,
    @SerializedName("strDescriptionPL")
    val strDescriptionPL: String?,
    @SerializedName("strColour1")
    val strColour1: String?,
    @SerializedName("strColour2")
    val strColour2: String?,
    @SerializedName("strColour3")
    val strColour3: String?,
    @SerializedName("strBadge")
    val strBadge: String?,
    @SerializedName("strLogo")
    val strLogo: String?,
    @SerializedName("strBanner")
    val strBanner: String?,
    @SerializedName("strEquipment")
    val strEquipment: String?,
    @SerializedName("strFanart1")
    val strFanart1: String?,
    @SerializedName("strFanart2")
    val strFanart2: String?,
    @SerializedName("strFanart3")
    val strFanart3: String?,
    @SerializedName("strFanart4")
    val strFanart4: String?,
)
