package kr.co.sy.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_news.view.*
import kr.co.sy.myapplication.model.entity.NewsEntity
import kr.co.sy.myapplication.adapter.holder.NewsViewHolder
import kr.co.sy.myapplication.R

class NewsAdapter(val list: List<NewsEntity>?) :RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.count()?:0
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        list?.get(position)?.let {
            holder.containerView.titleTxt.text =it.title
            holder.containerView.descriptionTxt.text =it.description
            holder.containerView.keyword1Txt.text =it.keyword1
            holder.containerView.keyword2Txt.text = it.keyword2
            holder.containerView.keyword3Txt.text = it.keyword3
        }

    }
}