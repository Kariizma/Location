package com.example.location.adapters

import CountriesAdapter
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.location.models.CountriesItem

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<CountriesItem>?) {
    val adapter = recyclerView.adapter as CountriesAdapter
    adapter.submitList(data)
}