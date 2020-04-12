package com.slepnev.movielist.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.appbar.AppBarLayout
import com.slepnev.movielist.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initViews()
    }

    private fun initViews() {
        var isShow = true
        var scrollRange = -1
        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { barLayout, verticalOffset ->
            if (scrollRange == -1){
                scrollRange = barLayout?.totalScrollRange!!
            }
            if (scrollRange + verticalOffset == 0){
                collapsingToolbarLayout.title = "Title Collapse"
                collapsingToolbarLayout.setCollapsedTitleTextColor(Color.parseColor("#FFFFFFFF"))
                isShow = true
            } else if (isShow){
                collapsingToolbarLayout.title = " " //careful there should a space between double quote otherwise it wont work
                isShow = false
            }
        })
    }
}
