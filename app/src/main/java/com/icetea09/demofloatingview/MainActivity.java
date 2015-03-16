package com.icetea09.demofloatingview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private Button mBtnShowView;
    private boolean mIsFloatingViewShow; //Flag variable used to identify if the Floating View is visible or not

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnShowView = (Button)findViewById(R.id.btn_show_floating_view);
        mBtnShowView.setOnClickListener(this);
        mIsFloatingViewShow = false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_show_floating_view:
                if(mIsFloatingViewShow){
                    hideFloatingView();
                    mIsFloatingViewShow = false;
                    mBtnShowView.setText(R.string.show_floating_view);
                }
                else{
                    showFloatingView();
                    mIsFloatingViewShow = true;
                    mBtnShowView.setText(R.string.hide_floating_view);
                }
                break;
        }
    }

    private void showFloatingView() {
        startService(new Intent(getApplicationContext(), FloatingViewService.class));
    }

    private void hideFloatingView() {
        stopService(new Intent(getApplicationContext(), FloatingViewService.class));
    }

}
