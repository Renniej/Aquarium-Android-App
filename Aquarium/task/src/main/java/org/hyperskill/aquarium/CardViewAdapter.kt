package org.hyperskill.aquarium

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CardViewAdapter(val name : List<String>, val desc : List<String>, val image : List<String>) : RecyclerView.Adapter<CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder = CardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_view_template, parent, false))

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

        holder.itemView.run {

            val nameView = findViewById<TextView>(R.id.tv_name);
            val descView = findViewById<TextView>(R.id.tv_description)
            val imageView = findViewById<ImageView>(R.id.image_view)

            nameView.text = name[position];
            descView.text=desc[position];
            Picasso.get().load(image[position])
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .fit()
                .into(imageView)
        }


    }

    override fun getItemCount(): Int {
        return name.size;
    }

}