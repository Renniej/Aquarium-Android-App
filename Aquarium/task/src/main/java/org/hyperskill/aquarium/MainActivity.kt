package org.hyperskill.aquarium

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.squareup.picasso.Picasso



class MainActivity : AppCompatActivity() {

    private var curPageIndex : Int = 0;
    private val lastPageIndex = 2;
    private var nameAnimals : List<String> = listOf("Koi Carp", "Spiny Dogfish", "Kaluga");
    private var descriptionAnimals : List<String> = listOf(

        //Koi Carp
        "These colorful, ornamental fish are a variety of the Amur carp. " +
                "They were originally found in Central Europe and Asia, " +
                "but they’ve spread to many other parts of the world. " +
                "Koi carp are popular with breeders, and there are currently over 100 varieties " +
                "created through breeding.\n" +
                "\n" +
                "The average age of a koi carp can vary based on the part of the world it’s bred in. " +
                "Carps bred outside of Japan have an average lifespan of around 15 years," +
                " while carps bred in Japan can live 40 years or more. The oldest koi carp on record," +
                " which was a fish named Hanako, reportedly lived for 226 years!",

        // Spiny dogfish
        "The spiny dogfish is a type of shark with venomous spines in front of its dorsal fins." +
                " Not only is it an aggressive hunter, but these fish are known to hunt in packs!" +
                " Like many shark species, these fish grow slowly, " +
                "and some females don’t reach full maturity until they’re over 30 years old.\n" +
                "\n" +
                "While the lifespan of the spiny dogfish is already impressive, " +
                "some fish live for far longer than average. " +
                "Spiny dogfish in the Pacific Ocean tend to live longer than fish in the Atlantic," +
                " with some fish living longer than 80 years. " +
                "Females tend to mature later than males, and they usually live longer too.",

        //Kaluga
        "Sometimes called the river beluga, the kaluga is a type of predatory sturgeon." +
                " While these fish spend the majority of their time in freshwater, " +
                "they’re also able to survive in salt water. " +
                "The kaluga is one of the world’s largest freshwater fish species and can grow to be more than 18 feet long, " +
                "with a weight of over 2,200 pounds.\n" +
                "\n" +
                "Kalugas are overfished, which has left the species vulnerable to extinction. " +
                "Although many kaluga are killed before they fully mature, " +
                "these fish have the potential to live very long lives. " +
                "One kaluga that was caught in China is estimated to be over 100 years old."
    )

    private var imgAnimals : List<String> = listOf(
        "https://ucarecdn.com/42045846-b968-4a88-81ec-df73bec4fcb7/",

        "https://ucarecdn.com/5aa10eb3-fc49-4304-9057-adf1d29a9b4c/",

        "https://ucarecdn.com/c5fd39b9-7690-4616-b7dc-d3f8da883146/"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgAnimals =  intent.getSerializableExtra("imageAnimals") as? List<String> ?: imgAnimals
        nameAnimals = intent.getSerializableExtra("nameAnimals") as? List<String> ?: nameAnimals
        descriptionAnimals = intent.getSerializableExtra("descriptionAnimals") as? List<String> ?: descriptionAnimals


        val viewPager : ViewPager2  = findViewById(R.id.viewpager2)
        val cardAdapter = CardViewAdapter(nameAnimals,descriptionAnimals,imgAnimals);

        viewPager.adapter = cardAdapter;
    }


    private fun keepPageIndexInBounds() {
        curPageIndex = if (curPageIndex > lastPageIndex)
            0;
        else if (curPageIndex < 0)
            lastPageIndex
        else
            curPageIndex;
    }

    private fun refreshCardView() {
        
        val nameView = findViewById<TextView>(R.id.tv_name);
        val descView = findViewById<TextView>(R.id.tv_description)
        val imageView = findViewById<ImageView>(R.id.image_view)

        keepPageIndexInBounds();
        
        nameView.text = nameAnimals[curPageIndex]
        descView.text = descriptionAnimals[curPageIndex]
        Picasso.get().load(imgAnimals[curPageIndex]).error(R.drawable.error).placeholder(R.drawable.placeholder).fit().into(imageView)
    }


}