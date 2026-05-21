package io.aristiyo.favouritefeature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.EntryPointAccessors
import io.aristiyo.capstone.di.AppEntryPoint
import io.aristiyo.capstone.screen.detail.DetailTeamActivity
import io.aristiyo.core.ui.TeamItemAdapter
import io.aristiyo.favouritefeature.databinding.FragmentFavouriteBinding
import javax.inject.Inject

class FavouriteFragment : Fragment() {
    @Inject
    lateinit var factory: ViewModelFactory
    private var _binding: FragmentFavouriteBinding? = null
    val binding get() = _binding!!
    private val viewModel: FavouriteViewModel by viewModels { factory }
    private val teamItemAdapter =
        TeamItemAdapter { team ->
            val intent = Intent(activity, DetailTeamActivity::class.java)
            intent.putExtra(DetailTeamActivity.EXTRA_DATA, team)
            startActivity(intent)
        }

    override fun onAttach(context: Context) {
        DaggerFavouriteComponent
            .builder()
            .context(context)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    context.applicationContext,
                    AppEntryPoint::class.java,
                ),
            ).build()
            .inject(this@FavouriteFragment)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            viewModel.favouriteTeamList.observe(viewLifecycleOwner) { listFavouriteTeam ->
                teamItemAdapter.submitList(listFavouriteTeam)
                binding.tvNoData.isVisible = listFavouriteTeam.isNullOrEmpty()
            }

            binding.rvTeamList.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = teamItemAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvTeamList.adapter = null
        _binding = null
    }
}
