package com.e.myassignment;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.e.myassignment.Fragments.Fragment1;
import com.e.myassignment.Fragments.Fragment10;
import com.e.myassignment.Fragments.Fragment11;
import com.e.myassignment.Fragments.Fragment12;
import com.e.myassignment.Fragments.Fragment13;
import com.e.myassignment.Fragments.Fragment14;
import com.e.myassignment.Fragments.Fragment15;
import com.e.myassignment.Fragments.Fragment2;
import com.e.myassignment.Fragments.Fragment3;
import com.e.myassignment.Fragments.Fragment4;
import com.e.myassignment.Fragments.Fragment5;
import com.e.myassignment.Fragments.Fragment6;
import com.e.myassignment.Fragments.Fragment7;
import com.e.myassignment.Fragments.Fragment8;
import com.e.myassignment.Fragments.Fragment9;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private HomePagerAdapter mPagerAdapter;
    private ImageView img_leftArrow,img_rightArrow;
    private VerticalViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.vertical_viewpager);
        img_leftArrow = findViewById(R.id.img_leftArrow);
        img_rightArrow = findViewById(R.id.img_rightArrow);
        List<Fragment> list = new ArrayList<>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());
        list.add(new Fragment4());
        list.add(new Fragment5());
        list.add(new Fragment6());
        list.add(new Fragment7());
        list.add(new Fragment8());
        list.add(new Fragment9());
        list.add(new Fragment10());
        list.add(new Fragment11());
        list.add(new Fragment12());
        list.add(new Fragment13());
        list.add(new Fragment14());
        list.add(new Fragment15());
        mPagerAdapter = new HomePagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(mPagerAdapter);
        viewPager.setOffscreenPageLimit(1);

        img_leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem() != 0)
                    //viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                    viewPager.setCurrentItem(0);
            }
        });
        img_rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem() < viewPager.getAdapter().getCount())
                    //viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    viewPager.setCurrentItem(14);
            }
        });

    }

    @Override
    public void onBackPressed() {
        CloseAppDig();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void CloseAppDig() {
        LayoutInflater inflater = LayoutInflater.from(this);
        final View v = inflater.inflate(R.layout.activity_dig_appclose, null);
        androidx.appcompat.app.AlertDialog.Builder builer = new androidx.appcompat.app.AlertDialog.Builder(this);
        builer.setView(v);
        TextView Done_button =  v.findViewById(R.id.Done);
        TextView cancel_button =  v.findViewById(R.id.Cancel);
        builer.setCancelable(true);
        final androidx.appcompat.app.AlertDialog alert = builer.create();
        alert.getWindow().setGravity(Gravity.BOTTOM);
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert.show();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int displayWidth = displayMetrics.widthPixels;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(alert.getWindow().getAttributes());
        int dialogWindowWidth = (int) (displayWidth * 00.999f);
        layoutParams.width = dialogWindowWidth;
        alert.getWindow().setAttributes(layoutParams);
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.cancel();
            }
        });
        Done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent startMain = new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(startMain);
                    finishAffinity();
                } catch (Exception e) {

                }
            }
        });
    }

}

