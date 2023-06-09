package com.example.listedassignment.Fragment

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.listedassignment.Adapter.RvAdapter
import com.example.listedassignment.Api.BaseResponse
import com.example.listedassignment.R
import com.example.listedassignment.ViewModel.MainViewModel
import com.example.listedassignment.databinding.FragmentTopLinkBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopLinkFragment : Fragment(),RvAdapter.OnCopy {
    private lateinit var adapter:RvAdapter
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding:FragmentTopLinkBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopLinkBinding.inflate(layoutInflater)
        adapter = RvAdapter(this)
        binding.recyclerView.adapter = adapter
        viewModel.dashboardLiveData.observe(viewLifecycleOwner, Observer {
            when (it){
                is BaseResponse.Success -> {
                    adapter.submitList(it.data?.data?.topLinks)
                }
                else -> {}
            }
        })
        return binding.root
    }

    override fun onCopy(text: String) {
        val clipboard = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Copied Text", text)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(context, "Text copied to clipboard", Toast.LENGTH_SHORT).show()
    }

}