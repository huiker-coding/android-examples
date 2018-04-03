package com.example.waitdialogdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doClick(View view){
    	ProgressDialog dialog =ProgressDialog.getInstance(MainActivity.this);
    	dialog.showWaitPrompt();
    }

    
}
