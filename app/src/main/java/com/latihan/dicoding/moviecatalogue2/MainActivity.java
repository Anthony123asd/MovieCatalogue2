package com.latihan.dicoding.moviecatalogue2;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements MovieFragment.OnListFragmentInteractionListener, TvShowFragment.OnFragmentInteractionListener {

    private ViewPager mViewPager;
    private TabAdapter mTabAdapter;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() == null) {
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }
        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mTabLayout = findViewById(R.id.tabs);

        mTabAdapter = new TabAdapter(getSupportFragmentManager());
        mTabAdapter.addFragment(new MovieFragment(), "Movie");
        mTabAdapter.addFragment(new TvShowFragment(), "TV Show");
        mViewPager.setAdapter(mTabAdapter);

        mViewPager.setAdapter(mTabAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onListFragmentInteraction() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings) {
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}