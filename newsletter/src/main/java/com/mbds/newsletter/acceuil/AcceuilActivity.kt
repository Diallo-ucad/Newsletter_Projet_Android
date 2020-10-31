package com.mbds.newsletter.acceuil

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.mbds.newsletter.R
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import android.view.View.OnClickListener;
import com.mbds.newsletter.databinding.FragmentAcceuilBinding

class AcceuilActivity : AppCompatActivity() {

    private lateinit var bd:FragmentAcceuilBinding

    var sampleImages = arrayOf(
        "https://www.instinct-voyageur.fr/wp-content/uploads/2015/07/pays-du-monde.jpg",
        "https://www.alain-bensoussan.com/wp-content/uploads/2017/07/28168347.jpg",
        "https://les-petits-curieux.fr/wp-content/uploads/2020/01/HEADER-700x140px_Plan-de-travail-1-copie-2.jpeg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_acceuil)
        val carouselView = findViewById(R.id.carouselView) as CarouselView;
        carouselView.setPageCount(sampleImages.size);
        carouselView.setImageListener(imageListener);

    }
    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            // You can use Glide or Picasso here
            Picasso.get().load(sampleImages[position]).into(imageView)
            println("+++++++++++++++++++++++++++++++++++++++++++++LA POSITION $position")
        }
    }
}