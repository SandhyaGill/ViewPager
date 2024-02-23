package com.sandhyagill.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.sandhyagill.viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var layout = arrayListOf(R.layout.layout_page_one, R.layout.layout_page_two, R.layout.layout_page_three, R.layout.layout_page_four,
        R.layout.layout_page_five)
    var adapter = ViewPageRecycler(layout)
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = adapter
        binding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
//                    binding.llMain.set
                    binding.ivArrow.setOnClickListener {
                        val currentPosition = binding.viewPager.currentItem
                        if (currentPosition < layout.size - 1) {
                            binding.viewPager.currentItem = currentPosition + 1
                        }
                    }
                    binding.tvSkip.setOnClickListener {
                        val lastPosition = layout.size - 1
                        binding.viewPager.currentItem = lastPosition
                    }
                    for (i in 0 until layout.size) {
                        val imageView = when (i) {
                            0 -> binding.iv0
                            1 -> binding.iv1
                            2 -> binding.iv2
                            3 -> binding.iv3
                            4 -> binding.iv4
                            else -> null
                        }
                        imageView?.let {
                            if (position == i) {
                                it.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.blue))
                            } else {
                                it.setBackgroundColor(ContextCompat.getColor(this@MainActivity, android.R.color.transparent))
                            }
                        }
                    }
                    if (position==0){
                        binding.tvSkip.visibility = View.INVISIBLE
                        binding.ivArrow.visibility = View.INVISIBLE
                        binding.tvDone.visibility = View.INVISIBLE
//                        binding.iv0.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.red))

                    }else if (position==1){
                        binding.tvSkip.visibility = View.VISIBLE
                        binding.ivArrow.visibility = View.VISIBLE
                        binding.tvDone.visibility = View.GONE
//                        binding.iv1.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.blue))

                    }else if (position==2){
                        binding.tvSkip.visibility = View.VISIBLE
                        binding.ivArrow.visibility = View.VISIBLE
                        binding.tvDone.visibility = View.GONE
//                        binding.iv2.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.green))

                    }else if (position==3){
                        binding.tvSkip.visibility = View.VISIBLE
                        binding.ivArrow.visibility = View.VISIBLE
                        binding.tvDone.visibility = View.GONE
//                        binding.iv3.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.yellow))

                    }else{
                        binding.tvSkip.visibility = View.INVISIBLE
                        binding.ivArrow.visibility = View.GONE
                        binding.tvDone.visibility = View.VISIBLE
//                        binding.iv4.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.purple))

                    }
                    Log.e(TAG, "position $position")

                }

            }
        )
    }
}