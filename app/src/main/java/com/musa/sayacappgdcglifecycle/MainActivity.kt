package com.musa.sayacappgdcglifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.musa.sayacappgdcglifecycle.databinding.ActivityMainBinding
import timber.log.Timber
import java.util.Timer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.toolbar))

        Timber.e("onCreat çalıştı")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val defaultValue = 0
        binding.apply {
            textViewSayac.text = defaultValue.toString()
            btnSay.setOnClickListener {
                val gelenDeger = textViewSayac.text.toString().toInt()
                textViewSayac.text = (gelenDeger + 1).toString()
            }
        }

    }

    private fun onPaylas() {
        println("tıklandıııı")
        val share = Intent.createChooser(Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, binding.textViewSayac.text.toString())
        }, null)
        startActivity(share)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.paylas_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.paylas ->
                onPaylas()

        }

        return super.onOptionsItemSelected(item)

    }

    override fun onStart() {
        super.onStart()
        Timber.e("onstart çalıştı")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.e("onRestart çalıştı")

    }

    override fun onResume() {
        super.onResume()
        Timber.e("onResume çalıştı")

    }

    override fun onPause() {
        super.onPause()
        Timber.e("onPause çalıştı")

    }

    override fun onStop() {
        super.onStop()
        Timber.e("onStop çalıştı")

    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.e("onDestroy çalıştı")

    }
}
