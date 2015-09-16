package com.chensl.rotatephotoview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.chensl.rotatephotoview.R;
import com.chensl.rotatephotoview.fragment.SinglePhotoViewFragment;
import com.chensl.rotatephotoview.fragment.ViewPagerPhotoViewFragment;

/**
 * Demo Activity contains<br/>
 * 1.Single<br/>
 * 2.ViewPager
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.replace_layout, SinglePhotoViewFragment.newInstance()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_single:
                getSupportFragmentManager().beginTransaction().replace(R.id.replace_layout, SinglePhotoViewFragment.newInstance()).commit();
                break;
            case R.id.action_viewpager:
                getSupportFragmentManager().beginTransaction().replace(R.id.replace_layout, ViewPagerPhotoViewFragment.newInstance()).commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
