package com.example.florian.palindrom;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText input;
    Button check;
    String res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        result = (TextView) findViewById(R.id.resultField);
        input = (EditText) findViewById(R.id.eingabeString);

        check = (Button) findViewById(R.id.checkButton);    //Button mit dem Code-Button verbinden
        check.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String inputString = input.getText().toString();  //Input aus dem Feld zuweisen

                if (inputString.isEmpty()){
                    res = "Input ist leer";
                    result.setText(res);
                }
                if (inputString.length() > 0 && inputString.length() < 5){
                    res = "Input String zu kurz";
                }
                else{
                    Boolean resB = isPalindrome(inputString);
                    if (resB){
                        res = "JA!";
                    }
                    else{
                        res = "NEIN!";
                    }
                }
                result.setText(res);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static boolean isPalindrome(String str){
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
