package com.example.editorials

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*

class NewsViewHolder(view : View): RecyclerView.ViewHolder(view){
    fun Bind(model: News) {
        itemView.newsTitleTextView.text = model.title

     //   if (model.thumbnail.isEmpty()) {
      //      itemView.newsThumbnailImageView.setImageResource(R.drawable.placeholder);
       // } else{
            Picasso.with(itemView.context).load(model.thumbnail).into(itemView.newsThumbnailImageView)
       // }

    }
}