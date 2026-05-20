package io.aristiyo.capstone.screen.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.aristiyo.capstone.databinding.FragmentHomeBinding
import io.aristiyo.capstone.screen.detail.DetailTeamActivity
import io.aristiyo.core.source.ResultStatus
import io.aristiyo.core.ui.TeamItemAdapter

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private val teamItemAdapter = TeamItemAdapter { team ->
        val intent = Intent(activity, DetailTeamActivity::class.java)
        intent.putExtra(DetailTeamActivity.EXTRA_DATA, team)
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            viewModel.teamList.observe(viewLifecycleOwner) { result ->
                if (result != null) {
                    when (result) {
                        is ResultStatus.Loading -> {
                            binding.progressBar.isVisible = true
                        }

                        is ResultStatus.Success -> {
                            binding.progressBar.isVisible = false
                            teamItemAdapter.submitList(result.data)
                        }

                        is ResultStatus.Error -> {
                            binding.progressBar.isVisible = false
                            Toast.makeText(
                                activity,
                                result.message ?: "Something Wrong :(",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
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