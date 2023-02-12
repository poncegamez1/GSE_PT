package com.example.gse_pt.list


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gse_pt.R
import com.example.gse_pt.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModels()
    private lateinit var listBinding: FragmentListBinding
    private lateinit var userAdapter: ListAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        setupAdapter()
        setupRecyclerView()
        addSubscriptions()
        return listBinding.root

    }

    private fun setupAdapter(){
        userAdapter = ListAdapter()
    }

    private fun setupRecyclerView(){
        listBinding.usersRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
            setHasFixedSize(false)
        }
    }

    private fun addSubscriptions(){
        viewModel.onUserState.observe(viewLifecycleOwner) { result ->
            if(result.isNotEmpty()){
                userAdapter.appendItems(result)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUsersFromServer()
    }



}