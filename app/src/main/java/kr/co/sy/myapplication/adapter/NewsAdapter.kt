package kr.co.sy.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_news.view.*
import kr.co.sy.myapplication.NewsModel
import kr.co.sy.myapplication.NewsViewHolder
import kr.co.sy.myapplication.R

class NewsAdapter(val list: List<NewsModel>) :RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.containerView.titleTxt.text = list[position].title
        holder.containerView.descriptionTxt.text = list[position].description
        holder.containerView.keyword1Txt.text = list[position].keyword1
        holder.containerView.keyword2Txt.text = list[position].keyword2
        holder.containerView.keyword3Txt.text = list[position].keyword3
    }
}