package com.dicoding.picodiploma.submitionmentreeapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class detailmentor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailmentor)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Mentoring"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetJenis: TextView = findViewById(R.id.tv_item_jenis)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvSetDetail: TextView = findViewById(R.id.tv_item_detail)
        val tvLayanan: TextView = findViewById(R.id.tv_item_layanan)
        val tvFavorite: TextView = findViewById(R.id.tv_item_favorite)

        val tJenis  = intent.getStringExtra(EXTRA_JENIS)
        val tImg = intent.getStringExtra(EXTRA_PHOTO)
        val tLayanan = intent.getStringExtra(EXTRA_LAYANAN)
        val tDetail= intent.getStringExtra(EXTRA_DETAIL)
        val tFavorite = intent.getStringExtra(EXTRA_FAVORITE)



        tvSetJenis.text = tJenis
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvLayanan.text = tLayanan
        tvSetDetail.text = tDetail
        tvFavorite.text = tFavorite
    }

    companion object {
        const val EXTRA_JENIS = "extra_jenis"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_LAYANAN = "extra_layanan"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_FAVORITE = "extra_favorite"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}