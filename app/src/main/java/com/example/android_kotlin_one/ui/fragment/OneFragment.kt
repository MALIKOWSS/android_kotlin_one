package com.example.android_kotlin_one.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.android_kotlin_one.databinding.FragmentOneBinding
import com.example.android_kotlin_one.ui.adapter.OneAdapter
import com.example.android_kotlin_one.ui.adapter.TwoAdapter
import com.example.android_kotlin_one.ui.model.Model
import com.example.android_kotlin_one.ui.repository.Repository

class OneFragment : Fragment() {

    private var binding: FragmentOneBinding? = null
    private var adapterOne: OneAdapter? = null
    private var adapterTwo: TwoAdapter? = null
    private val repository = Repository()
    private var mainList: ArrayList<Model>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        mainList = repository.getListModelData()
        adapterOne = OneAdapter(mainList as ArrayList<Model>, this::onClickFirstListener)
        adapterTwo = TwoAdapter(mainList as ArrayList<Model>, this::onClickSecondListener)
        val concatAdapter = ConcatAdapter(adapterOne, adapterTwo)
        binding?.rvMain?.adapter = concatAdapter
    }

    private fun onClickFirstListener(mainModel: Model) {
        findNavController().navigate(
            OneFragmentDirections.actionMain(
                mainModel.name
            )
        )
    }

    private fun onClickSecondListener(mainModel: Model) {
        findNavController().navigate(
            OneFragmentDirections.action(
                mainModel.image
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainList?.clear()
        binding = null
    }
}