package com.example.editorials

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.mobymagic.easyfirebaselist.EmptyStyle
import com.mobymagic.easyfirebaselist.ErrorStyle
import com.mobymagic.easyfirebaselist.ProgressStyle
import com.mobymagic.easyfirebaselist.database.FirebaseDbListFragment
import com.thefinestartist.finestwebview.FinestWebView

/**
 * A simple [Fragment] subclass.
 * Use the [NewsListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsListFragment : FirebaseDbListFragment<News, NewsViewHolder>() {
    override fun getDataClass(): Class<News> {
        return News::class.java
    }

    override fun getEmptyStyle(): EmptyStyle {
        return EmptyStyle(R.mipmap.ic_launcher, "No News Yet")
    }

    override fun getErrorStyle(error: DatabaseError): ErrorStyle {
        return ErrorStyle(R.mipmap.ic_launcher, "An error occurred while fetching news")
    }

    override fun getProgressStyle(): ProgressStyle {
        return ProgressStyle("Loading...")
    }

    override fun getQuery(): Query {
        return FirebaseDatabase.getInstance().reference.child("news").limitToLast(100)
    }

    override fun onBindViewHolder(viewHolder: NewsViewHolder, key: String, model: News) {
        viewHolder.Bind(model)
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup): NewsViewHolder {
        val view = inflater.inflate(R.layout.item_news,viewGroup, false)
        return NewsViewHolder(view)
    }

    override fun onItemClicked(viewHolder: NewsViewHolder, key: String, model: News) {
       // FinestWebView.Builder(activity).show(model.link);

    }

    override fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
        recyclerView.layoutManager = LinearLayoutManager(activity)

    }

}