package com.example.popupwindow;

import com.example.popupwindow.views.TakePhotoPopWindow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showPopFormBottom(View view) {
    	  TakePhotoPopWindow takePhotoPopWin = new TakePhotoPopWindow(this, onClickListener);
    	  //showAtLocation(View parent, int gravity, int x, int y)
    	  takePhotoPopWin.showAtLocation(findViewById(R.id.main_view), Gravity.CENTER, 0, 0);
    	}
    	  
    	private View.OnClickListener onClickListener = new View.OnClickListener() {
    	  @Override
    	  public void onClick(View v) {
    	  
    	    switch (v.getId()) {
    	      case R.id.btn_take_photo:
    	        System.out.println("btn_take_photo");
    	        break;
    	      case R.id.btn_pick_photo:
    	        System.out.println("btn_pick_photo");
    	        break;
    	    }
    	  }
    	};    
}
