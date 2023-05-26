package com.example.listedassignment.Fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.listedassignment.Adapter.ViewPagerAdapter
import com.example.listedassignment.Api.BaseResponse
import com.example.listedassignment.Api.model.MapDataModel
import com.example.listedassignment.Utiles.SessionManager
import com.example.listedassignment.Utiles.UtilesFunction
import com.example.listedassignment.ViewModel.MainViewModel
import com.example.listedassignment.databinding.FragmentLinkFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.entryModelOf
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class LinkFragment : Fragment() {
    private lateinit var viewPagerAdapter:ViewPagerAdapter
    private var mapData = mutableListOf<MapDataModel>()
    private var endPoint = "dashboardNew"
    private var whats_app = ""
    val USER_TOKEN = "user_token"
    private lateinit var binding:FragmentLinkFragmentBinding
    private val viewModel:MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLinkFragmentBinding.inflate(layoutInflater)
        if(SessionManager.getString(requireContext(),USER_TOKEN)=="null"){
            SessionManager.saveJWTToken(requireContext(), SessionManager.token)
        }
        viewModel.getDashboardData(endPoint)
        binding.whatsAppSupport.setOnClickListener {
            val url = "https://api.whatsapp.com/send?phone=$whats_app"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        binding.greet.setOnClickListener {
            viewModel.getDashboardData(endPoint)
        }
        setUp()
        observeViewModel()
        return binding.root
    }
    private fun setUp(){
        viewPagerAdapter  = ViewPagerAdapter(requireActivity().supportFragmentManager,lifecycle)
        binding.viewPager2.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayout,binding.viewPager2)
        {
                tab,position->
            when(position){
                0->{ tab.text = "Top Links" }
                1->{tab.text = "Recent Links"}

            }
        }.attach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.greet.text  = greetTime()
    }
    private fun observeViewModel(){
        viewModel.dashboardLiveData.observe(viewLifecycleOwner, Observer {
            when(it){
                is BaseResponse.Loading ->{
                    binding.graphLoader.visibility = View.VISIBLE
                }
                is BaseResponse.Success ->{
                    binding.click.text = it.data?.todayClicks.toString()
                    binding.location.text = it.data?.topLocation
                    binding.source.text = it.data?.topSource
                    it.data?.supportWhatsappNumber?.let { whats_app = it }
                    mapData = UtilesFunction.convertList(it.data?.data?.overallUrlChart)
                    binding.dateRange.text = "${mapData[0].key} - ${mapData[mapData.size-1].key}"
                    val model = entryModelOf(UtilesFunction.floatingList)
                    binding.graphLoader.visibility = View.GONE
                    binding.chart.setModel(model)
                }
                is BaseResponse.Error ->{
                    binding.graphLoader.visibility = View.GONE
                }
                else -> {
                    binding.graphLoader.visibility = View.GONE

                }
            }
        })

    }
  private  fun greetTime():String{
      val currentTime = Calendar.getInstance()
      val hour = currentTime.get(Calendar.HOUR_OF_DAY)
      val greeting = when {
          hour < 12 -> "Good morning"
          hour < 18 -> "Good afternoon"
          else -> "Good evening"
      }
      return greeting
    }

}