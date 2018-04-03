package com.example.listview.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listViewStyle1(View view) {
        Intent it = new Intent(MainActivity.this, ListViewActivity1.class);
        startActivity(it);
    }
}
