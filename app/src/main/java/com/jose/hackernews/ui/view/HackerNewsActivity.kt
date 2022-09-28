package com.jose.hackernews.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jose.hackernews.core.SwipeToDeleteCallback
import com.jose.hackernews.data.model.Hits
import com.jose.hackernews.databinding.ActivityHackerNewsBinding
import com.jose.hackernews.ui.viewmodel.HackerNewViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HackerNewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHackerNewsBinding

    private val hackerNewViewModel: HackerNewViewModel by viewModels()

    var adapter: HackerNewsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHackerNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        hackerNewViewModel.onCreate()

        hackerNewViewModel.hackerNewsModel.observe(this) {
            adapter = HackerNewsAdapter( it)
            binding.recyclerViewHackerNews.adapter = adapter
            val swipeHandler = object : SwipeToDeleteCallback(this) {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                }
            }
            val itemTouchHelper = ItemTouchHelper(swipeHandler)
            itemTouchHelper.attachToRecyclerView(binding.recyclerViewHackerNews)
            onClickListeners()
        }

        hackerNewViewModel.isLoading.observe(this) { isVisible ->
            binding.progressCircular.isVisible = isVisible
        }
    }

    private fun onClickListeners() {
        binding.refreshLayout.setProgressViewOffset(true, 20, 70)
        binding.refreshLayout.setOnRefreshListener {
            hackerNewViewModel.onCreate()
        }
    }

    private fun initRecyclerView() {
        binding.recyclerViewHackerNews.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

}
