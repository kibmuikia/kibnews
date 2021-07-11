package kib.dev.kibnews.ui.activities.main_activity.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kib.dev.kibnews.R

class HomeFragment : Fragment() {

    private val logTag: String = HomeFragment::class.java.simpleName
    private lateinit var viewModel: HomeViewModel
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        rootView = inflater.inflate(R.layout.fragment_home, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        initializeListeners()
    }

    override fun onDestroyView() {
        //rootView = null
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun observeViewModel() {

//        val textView: TextView = rootView.findViewById(R.id.text_home)
        viewModel.text.observe(viewLifecycleOwner, Observer {
            //textView.text = it
            //Log.e(logTag, ": observeViewModel: homeViewModel.text.observe(: it: $it")
        })

        viewModel.badgeCount.observe(viewLifecycleOwner, Observer {
//            text_home?.text = it.toString()
            //Log.e(logTag, ": observeViewModel: homeViewModel.badgeCount.observe(: it: $it")
        })
        viewModel.getTopHeadlines()
    }

    private fun initializeListeners() {

//        btn_frag_home_badgecount?.setOnClickListener {
//            //homeViewModel.incrementBadgeCount()
//            homeViewModel.getTopHeadlines()
//        }
    }
}