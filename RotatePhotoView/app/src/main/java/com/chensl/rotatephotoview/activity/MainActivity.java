package com.chensl.rotatephotoview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chensl.rotatephotoview.R;
import com.chensl.rotatephotoview.fragment.PhotoViewFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.replace_layout, PhotoViewFragment.newInstance()).commit();
    }

}
