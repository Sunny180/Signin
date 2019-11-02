package com.example.signin;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private EditText edname;
    private EditText edpassword;
    private EditText edemail;
    private ImageView resultname;
    private ImageView resultpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edname = findViewById(R.id.ed_name);
        edpassword = findViewById(R.id.ed_password);
        edemail = findViewById(R.id.ed_email);
        edname = findViewById(R.id.ed_name);
        resultname = findViewById(R.id.im_name);
        resultpassword = findViewById(R.id.im_password);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void Signin (View view){
        final String name = edname.getText().toString();
        String password = edpassword.getText().toString();
        String email = edemail.getText().toString();
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                edname.setText("");
                edpassword.setText("");
                edemail.setText("");
            }
        };
        if(name.length() < 4){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Error")
                    .setMessage("Name at least 4 word")
                    .setPositiveButton("OK",null)
                    .show();
            resultname.setVisibility(View.VISIBLE);
            resultname.setImageResource(R.drawable.bad);
        }else{
            resultname.setVisibility(View.INVISIBLE);
        }
        if(password.length() < 6){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Error")
                    .setMessage("Password at least 6 word")
                    .setPositiveButton("OK",null)
                    .show();
            resultpassword.setVisibility(View.VISIBLE);
            resultpassword.setImageResource(R.drawable.bad);
        }else{
            resultpassword.setVisibility(View.INVISIBLE);
        }
        if(name.length() >= 4 && password.length() >= 6){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Success")
                    .setMessage("Welcome " + name + " sign in")
                    .setPositiveButton("OK", listener)
                    .show();
        }

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
}
