package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Joshua on 3/23/14.
 */
public class Clicker extends Activity{

    private int x = 0;

    public void buttonOnClick(View v){

        TextView myTextView = (TextView) findViewById(R.id.textView);
        TextView numClicks = (TextView) findViewById(R.id.clicks);
        numClicks.setText(" "+x);

        if(x == 0){
            myTextView.setText("Oh, Hello there!");
        }
        if(x == 1){
            myTextView.setText("Welcome to the clicker.");
        }
        if(x == 2){
            myTextView.setText("All you have to do is click and I am forced to talk to you!");
        }
        if(x == 3){
            myTextView.setText("So...");
        }
        if(x == 4){
            myTextView.setText("That is it, though seems my programmer is just making more stuff for me to say... ");
        }


        if(x%10 == 0){
            Toast.makeText(this, "Torch clicked "+x+" times", Toast.LENGTH_LONG).show();
        }



        x++;

    }//buttonOnClick end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicker);

        Toast.makeText(this, "CLICK THE TORCH", Toast.LENGTH_LONG).show();
    }
}
