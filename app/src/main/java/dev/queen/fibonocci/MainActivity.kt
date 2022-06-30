package dev.queen.fibonocci

import android.content.ContentValues.TAG
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
        var numberList = fibo(100)
        var numberAdapter = NumberRecyclerViewAdapter(numberList)

        binding.rvFibo.layoutManager = LinearLayoutManager(this)
        binding.rvFibo.adapter = numberAdapter
    }


    fun fibo(n: Int):List<Int> {
        var list = ArrayList<Int>()
        var prev = 0
        var prevOne = 1

        for (i in 0..n) {
            var sum = prev + prevOne
            prev = prevOne
            prevOne = sum
            list+=sum

            Log.d(TAG,"${sum}")

        }

        return list
    }


}