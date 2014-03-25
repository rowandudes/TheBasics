package com.example.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Joshua on 3/23/14.
 */
public class menu extends Activity {

    EditText isItPrime;
    TextView myTextView;
    boolean primeOutcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        Button tut1 = (Button) findViewById(R.id.tutorial1);
        tut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent("com.example.app.CLICKER"));
            }
        });

        Button tut2 = (Button) findViewById(R.id.tutorial2);
        isItPrime = (EditText) findViewById(R.id.number);
        myTextView = (TextView) findViewById(R.id.answer);

        tut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {;
                if(isItPrime.getText().toString().equals("")){
                    Context context = getApplicationContext();
                    CharSequence text = "You have entered nothing";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                int subject = Integer.parseInt(isItPrime.getText().toString()) ;

                        if(isPrime(subject)){
                        Context context = getApplicationContext();
                        CharSequence text = "It is Prime";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                       //myTextView.setText("It is Prime");
                    }else{
                        Context context = getApplicationContext();
                        CharSequence text = "It is not Prime";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        //myTextView.setText("It is not Prime");
                    }
                }
            }

        });

    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    /**
     * This method checks if the input is Prime or not
     *
     */
    public boolean isPrime(int n)
    {

        if(n == 2)
        {
            return true;
        }
        else if(n<= 1)
        {
            return false;
        }
        else
        {
            for(int i = 2; i*i <= n; i++)
            {
                if((n%i) == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }

}
