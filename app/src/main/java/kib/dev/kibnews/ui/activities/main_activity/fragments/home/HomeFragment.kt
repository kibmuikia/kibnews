package kib.dev.kibnews.ui.activities.main_activity.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kib.dev.kibnews.R
import kib.dev.kibnews.databinding.FragmentHomeBinding
import kib.dev.kibnews.init.App

class HomeFragment : Fragment() {

    private val logTag: String = HomeFragment::class.java.simpleName
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        initializeListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun observeViewModel() {
        viewModel.text.observe(viewLifecycleOwner, Observer {
            binding.tvFragHomeLabelCategories.text = it
            //Log.e(logTag, ": observeViewModel: homeViewModel.text.observe(: it: $it")
        })
        viewModel.getTopHeadlines()
    }

    private fun initializeListeners() {
        binding.tvFragHomeLabelCategories.setOnClickListener {
            Toast.makeText(App.appContext(), "Hi There", Toast.LENGTH_LONG).show()
        }
    }
}