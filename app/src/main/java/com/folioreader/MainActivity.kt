package com.folioreader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val folioreader = FolioReader.get()

        btn_read_fromasset.setOnClickListener {
            folioreader.openBook("file:///android_asset/TheSilverChair.epub")
        }
        btn_read_fromraw.setOnClickListener {
            folioreader.openBook(R.raw.accessible_epub_3)
        }
    }
}
