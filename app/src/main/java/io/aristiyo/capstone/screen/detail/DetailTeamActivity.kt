package io.aristiyo.capstone.screen.detail

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import io.aristiyo.capstone.R
import io.aristiyo.capstone.databinding.ActivityDetailTeamBinding
import io.aristiyo.core.domain.model.Team
import io.aristiyo.core.ui.FanartAdapter
import io.aristiyo.core.utils.loadImage
import io.aristiyo.core.utils.setColourDot

@AndroidEntryPoint
class DetailTeamActivity : AppCompatActivity() {
    private val binding: ActivityDetailTeamBinding by lazy {
        ActivityDetailTeamBinding.inflate(layoutInflater)
    }
    private val viewModel: DetailTeamViewModel by viewModels()
    private val fanartAdapter = FanartAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val dataDetailTeam = IntentCompat.getParcelableExtra(intent, EXTRA_DATA, Team::class.java)

        dataDetailTeam?.let { team ->
            setupViews(team)
            setupSocialMedia(team)
            setupImages(team)
            setupRecyclerView(team.fanartUrls)
            setupFavoriteButton(team)
            setupDescriptionToggle()
        }
    }

    private fun setupViews(team: Team) =
        with(binding) {
            tvTeamName.text = team.name
            tvNameAlternate.text = team.nameAlternate
            chipShortName.text = team.nameShort
            tvLeague.text = team.league
            tvCountry.text = team.country
            tvFormedYear.text = getString(R.string.format_formed_year, team.formedYear)
            tvStadium.text = team.stadium
            tvCapacity.text = getString(R.string.format_capacity, team.stadiumCapacity)
            tvLocation.text = team.location
            tvDescription.text = team.description

            viewColour1.setColourDot(team.colourPrimary)
            viewColour2.setColourDot(team.colourSecondary)
            viewColour3.setColourDot(team.colourTertiary)

            team.keywords?.split(",")?.forEach { keyword ->
                cgKeywords.addView(
                    Chip(this@DetailTeamActivity).apply {
                        text = keyword.trim()
                    },
                )
            }
        }

    private fun setupSocialMedia(team: Team) =
        with(binding) {
            val socialPlatforms =
                listOf(
                    btnWeb to team.website,
                    btnTwitter to team.twitter,
                    btnInstagram to team.instagram,
                    btnFacebook to team.facebook,
                    btnYoutube to team.youtube,
                )

            socialPlatforms.forEach { (button, url) ->
                button.isVisible = !url.isNullOrBlank()
                button.setOnClickListener { openUrl("https://$url") }
            }
        }

    private fun setupImages(team: Team) =
        with(binding) {
            imgBanner.loadImage(team.bannerUrl)
            imgBadge.loadImage(team.badgeUrl)
            imgEquipment.loadImage(team.equipmentUrl)
        }

    private fun setupRecyclerView(urls: List<String>) {
        fanartAdapter.submitList(urls.filter { it.isNotBlank() })
        binding.rvFanart.apply {
            adapter = fanartAdapter
            layoutManager =
                LinearLayoutManager(this@DetailTeamActivity, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setupFavoriteButton(team: Team) {
        var isFavourite = team.isFavourite
        updateFavoriteIcon(isFavourite)

        binding.fabFavourite.setOnClickListener {
            isFavourite = !isFavourite
            viewModel.saveFavouriteTeam(team, isFavourite)
            updateFavoriteIcon(isFavourite)
        }
    }

    private fun setupDescriptionToggle() =
        with(binding) {
            var isExpanded = false
            btnReadMore.setOnClickListener {
                isExpanded = !isExpanded
                tvDescription.maxLines = if (isExpanded) Int.MAX_VALUE else 4
                btnReadMore.text =
                    getString(
                        if (isExpanded) R.string.action_read_less else R.string.action_read_more,
                    )
            }
        }

    private fun updateFavoriteIcon(isFavorite: Boolean) {
        val iconRes = if (isFavorite) R.drawable.ic_favorite else R.drawable.ic_not_favorite
        binding.fabFavourite.setImageDrawable(ContextCompat.getDrawable(this, iconRes))
    }

    private fun openUrl(url: String) {
        runCatching {
            startActivity(Intent(Intent.ACTION_VIEW, url.toUri()))
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}
