package com.example.qrpaynew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class QRScannerActivity extends AppCompatActivity {
    Fragment cFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrscanner);

        final QRScannerFragment qrScannerFragment = new QRScannerFragment();

        //set a Fragment to the activity
        Fragment fragment = new QRScannerFragment();
        changeFragment(fragment,false);
    }

    private void changeFragment(Fragment fr,boolean addtoBackstack) {
        cFrag = fr;
        String fragmentClass=fr.getClass().getSimpleName();
        FragmentManager fm = getSupportFragmentManager();

        if (fm.findFragmentById(fr.getId()) == null) {
            //Log.v(TAG,"hello");
            FragmentTransaction ft = fm.beginTransaction();
            if(addtoBackstack){
                ft.addToBackStack(fragmentClass);
            }
            ft.replace(R.id.fragment_container, fr);
            ft.commit();
        }
    }
}