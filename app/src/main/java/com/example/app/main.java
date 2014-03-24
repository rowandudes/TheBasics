package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ImageView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class main extends Activity {


    private final int MENU_DISPLAY_LENGHT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView myAnimation = (ImageView)findViewById(R.id.myanimation);
        final AnimationDrawable myAnimationDrawable = (AnimationDrawable)myAnimation.getDrawable();
        myAnimation.post(
                new Runnable(){

                    @Override
                    public void run() {
                        myAnimationDrawable.start();
                    }
                });

        Thread logoTimer = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                    Intent menuIntent = new Intent("com.example.app.MENU");
                    startActivity(menuIntent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally{
                    finish();
                }
            }
        };
        logoTimer.start();



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
