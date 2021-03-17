package com.dicoding.picodiploma.submitionmentreeapps

import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListMentorAdapter(val listMentor: ArrayList<Mentor>) : RecyclerView.Adapter<ListMentorAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_mentor, viewGroup,false )
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMentor.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (jenis,favorite, photo, layanan, detail,) = listMentor[position]

        Glide.with(holder.itemView.context)
                .load(photo)
                .apply(RequestOptions())
                .into(holder.imgPhoto)

        holder.tvJenis.text = jenis
        holder.tvFavorite.text = favorite

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, detailmentor::class.java)
            moveDetail.putExtra(detailmentor.EXTRA_FAVORITE, favorite)
            moveDetail.putExtra(detailmentor.EXTRA_JENIS, jenis)
            moveDetail.putExtra(detailmentor.EXTRA_PHOTO, photo)
            moveDetail.putExtra(detailmentor.EXTRA_DETAIL, detail)
            moveDetail.putExtra(detailmentor.EXTRA_LAYANAN, layanan)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvJenis: TextView = itemView.findViewById(R.id.tv_item_jenis)
        var tvFavorite: TextView = itemView.findViewById(R.id.tv_item_favorite)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}