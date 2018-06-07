package com.smilehacker.coroutinestest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.coroutines.experimental.CommonPool
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
        thread {
            val jobs = List(100_00) {
                thread {
                    Thread.sleep(1000L)
                    Log.i("thread", "I'm Thread ${Thread.currentThread().name}")
                }
            }
            jobs.forEach(Thread::join)
        }
    }

    private fun testCoroutines() {
        thread {
            val jobs = List(100_000) {
                launch(CommonPool) {
                    delay(1000L)
                    Log.i("thread", "I'm Thread ${Thread.currentThread().name}")
                }
            }
            jobs.forEach { it.start()}
        }
    }
}
