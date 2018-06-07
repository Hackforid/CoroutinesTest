package com.smilehacker.coroutinestest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.tv_rua_thread).setOnClickListener {
            testThread()
        }

        findViewById<View>(R.id.tv_rua_coroutines).setOnClickListener {
            testCoroutines()
        }
    }

    private fun testThread() {
        repeat(100_000) {
            thread {
//                Log.i("thread", "I'm Thread $it, run on ${Thread.currentThread().name}")
                Thread.sleep(1000L)
            }
        }
    }

    private fun testCoroutines() {
        repeat(100_000) {
            launch {
//                Log.i("coroutines", "I'm Thread $it, run on ${Thread.currentThread().name}")
                delay(1000)
            }
        }
    }
}
