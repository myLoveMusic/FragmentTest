package com.bc.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    Button btnTing,btnKan,btnChang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTing= (Button) findViewById(R.id.btn_ting);
        btnKan= (Button) findViewById(R.id.btn_chang);
        btnChang= (Button) findViewById(R.id.btn_chang);
        btnTing.setOnClickListener(this);
        btnKan.setOnClickListener(this);
        btnChang.setOnClickListener(this);

        switchContent(new FragmentTing());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ting:
                switchContent(new FragmentTing());
                break;
            case R.id.btn_kan:
                switchContent(new FragmentKan());
                break;
            case R.id.btn_chang:
                switchContent(new FragmentChang());
                break;
            default:
                break;
        }
    }

    public void switchContent(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.lin,fragment);
        fragmentTransaction.commit();
    }
}
