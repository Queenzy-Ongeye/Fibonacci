package dev.queen.fibonocci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import dev.queen.fibonocci.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayNumbers()
    }

    fun displayNumbers() {
        var numberList = listOf(numbers(100))
        var numberAdapter = NumberRecyclerViewAdapter(numberList)

        binding.rvFibo.layoutManager = LinearLayoutManager(this)
        binding.rvFibo.adapter = numberAdapter
    }

    fun numbers(n: Int): Int {
        var prev1 = 0
        var prev2 = 1

        for (i in 1..n) {
            var sumNums = prev1
            prev1 = prev2
            prev2 = sumNums + prev1

        }
        return prev1

    }



}