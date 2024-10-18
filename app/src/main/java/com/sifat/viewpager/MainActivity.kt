package com.sifat.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.sifat.viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewPager: ViewPager2
    lateinit var pagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewpager // Assuming you have a ViewPager2 in your Activity layout
        pagerAdapter = ViewPagerAdapter()
        viewPager.adapter = pagerAdapter
    }

    inner class ViewPagerAdapter : RecyclerView.Adapter<ViewHolder>() {
        private val listOf = listOf(
            "জীবনে সত্যিকার সুখ তখনই মেলে, যখন আমরা অন্যদের সুখে অবদান রাখতে পারি।",
            "আপনি যদি একটি লক্ষ্য স্থির করেন এবং সেটির দিকে কাজ করেন, তবে তা অর্জন করা সম্ভব।",
            "সফলতার গোপন হলো, প্রথমে নিজের বিশ্বাসে বিশ্বাস করা।",
            "যে কষ্টের মধ্যে আপনি নিজের স্বপ্নের দিকে এগিয়ে যাচ্ছেন, সেটাই আপনার শক্তি।",
            "আপনার সময় সীমিত, তাই অন্যের জীবন যাপন করে সময় নষ্ট করবেন না।"
        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.page_layout, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return listOf.size // Return the size of the list
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = listOf[position]
            holder.bind(item)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val pagerText: TextView = itemView.findViewById(R.id.pagerText)

        fun bind(item: String) {
            pagerText.text = item
        }
    }
}
