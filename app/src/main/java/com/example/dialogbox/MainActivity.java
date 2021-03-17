package com.example.dialogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnD1, btnD2, btnD3, btnD4;
    String arr[] = {"Java", "Android", "Python", "Machine Learning"};
    String course;
    ArrayList al = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnD1 = findViewById(R.id.btnD1);
        btnD2 = findViewById(R.id.btnD2);
        btnD3 = findViewById(R.id.btnD3);
        btnD4 = findViewById(R.id.btnD4);

        btnD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                // Dialog box is build here(AlertDialog.Builder)
                ab.setTitle("Action");
                //This is the title of the Dialog box
                ab.setMessage("Do you want to continue?");
                //This is the message/warning of the dialog box
                ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    //Positive button is used for positive response
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Yes button clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Negative button is used for negative response
                        Toast.makeText(MainActivity.this, "No button clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                ab.show();
            }
        });


        btnD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                ab.setTitle("Courses Offered");
                ab.setSingleChoiceItems(arr, -1, new DialogInterface.OnClickListener() {
                    //If you do not want to select any value by default from the array then give "checkedItem" -1
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        course = arr[i];
                    }
                });
                ab.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Select Course : " + course, Toast.LENGTH_LONG).show();
                    }
                });
                ab.show();
            }
        });


        btnD3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                ab.setTitle("Courses Offered");
                ab.setMultiChoiceItems(arr, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        //here "int i" is the index value of the array
                        //"boolean b" is there to check if the item is checked or not
                        if (b) {
                            //if "b" is checked then add it to the array list
                            al.add(arr[i]);
                        } else {
                            al.remove(arr[i]);
                        }

                    }
                });
                ab.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Select Course : " + al, Toast.LENGTH_LONG).show();
                        al.clear();
                    }
                });
                ab.show();

            }
        });


        btnD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                ab.setTitle("Login Here");

                //Here we are converting the xml file(login.xml) to view (java file)
                LayoutInflater inflater = getLayoutInflater();
                View v = inflater.inflate(R.layout.login,null);

                ab.setView(v);

                ab.setPositiveButton("Sign In",null);
                ab.setNegativeButton("Cancel", null);
                ab.show();
            }
        });

    }
}