package com.app.ui.homepage

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.R
import com.app.api.RetrofitResult
import com.app.di.Injectable
import com.app.di.injectViewModel
import com.app.extensions.hide
import com.app.extensions.show
import com.app.ui.homepage.adapter.TimesAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_homepage.*
import javax.inject.Inject

class HomepageFragment : Fragment(R.layout.fragment_homepage), Injectable {

    companion object {
        fun newInstance() =
            HomepageFragment()
    }

    init {
        lifecycleScope.launchWhenStarted {
            initOnStart()
            initViews()
            doCall()
        }
    }

    private fun doCall() {
        viewModel.getTimes().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                RetrofitResult.Status.LOADING -> {
                    progressBar.show()
                }

                RetrofitResult.Status.SUCCESS -> {
                    progressBar.hide()
                    it.data?.let { response ->
                        val adapter = TimesAdapter(response.results)
                        rvTimes.adapter = adapter
                    }
                }

                RetrofitResult.Status.ERROR -> {
                    progressBar.hide()
                    Snackbar.make(
                        requireActivity().findViewById(android.R.id.content),
                        it.message!!,
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    private fun initViews() {
        rvTimes.setHasFixedSize(true)
        rvTimes.layoutManager = LinearLayoutManager(requireActivity())
    }

    private fun initOnStart() {
        viewModel = injectViewModel(viewModelFactory)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: HomepageVM
}