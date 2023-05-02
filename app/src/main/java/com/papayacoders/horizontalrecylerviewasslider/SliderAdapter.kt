package com.papayacoders.horizontalrecylerviewasslider

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoView
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class SliderAdapter (private val items: List<String>) :
    RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        if (item.endsWith(".mp4")) {
            holder.photoView.visibility = View.GONE
            holder.playerView.visibility = View.VISIBLE
            val context = holder.itemView.context
            val dataSourceFactory = DefaultDataSourceFactory(context, "exoplayer-slider")
            val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(item))
            holder.playerView.player = SimpleExoPlayer.Builder(context).build().apply {
                prepare(mediaSource)
                playWhenReady = false
            }
        }else {
            holder.photoView.visibility = View.VISIBLE
            holder.playerView.visibility = View.GONE
            Glide.with(holder.itemView.context).load(item).into(holder.photoView)

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photoView: PhotoView = itemView.findViewById(R.id.imageView)
        val playerView: PlayerView = itemView.findViewById(R.id.sliderItemVideo)
    }
}