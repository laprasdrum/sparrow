package com.laprasdrum.sparrow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSupportFragmentManager().beginTransaction()
                //                .add(R.id.container, MainFragment.newInstance())
                .add(R.id.container, SampleFragment.newInstance())
                .commit()
    }

}
