package com.example.kalpesh.pagesliderlib;

import android.app.Activity;

import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pageslider.PagerSlidingTab;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    PagerSlidingTab pagerTabStrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerTabStrip = (PagerSlidingTab)findViewById(R.id.slidingTab);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        init(0, pagerTabStrip, viewPager);


    }

    private void init(int index,final PagerSlidingTab pagerSliding, ViewPager viewPager){


        int length = pagerSliding.getTabCount();


        List<View> views = new ArrayList<View>(length);

        for(int w = 0; w < length; w++){



            views.add(getContentView(w));


        }

        viewPager.setAdapter(new PageAdapter(views));
        viewPager.setCurrentItem(index < length ? index : length);
        pagerSliding.setViewPager(viewPager);



        pagerSliding.setOnClickTabListener(new PagerSlidingTab.OnClickTabListener() {
            @Override
            public void onClickTab(View tab, int index) {

                Toast.makeText(getBaseContext(), "TAB" + (index + 1) , Toast.LENGTH_SHORT).show();
            }
        });

        pagerSliding.setOnDoubleClickTabListener(new PagerSlidingTab.OnDoubleClickTabListener() {
            @Override
            public void onDoubleClickTab(View view, int index) {

                Toast.makeText(getBaseContext(), "TAB" + (index + 1) , Toast.LENGTH_SHORT).show();
            }
        });


    }

    private View getContentView(int num){
        TextView view = new TextView(getBaseContext());
        view.setText("PAGE - "+num);
        view.setTextColor(Color.BLACK);
        view.setGravity(Gravity.CENTER);
        view.setTextSize(16f);
        return view;
    }




}
