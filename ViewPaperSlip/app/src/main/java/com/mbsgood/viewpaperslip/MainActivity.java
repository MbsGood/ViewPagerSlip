package com.mbsgood.viewpaperslip;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mbsgood.viewpaperslip.utils.CommonUtils;

import java.util.ArrayList;

/**
 * View 切换滑动
 */
public class MainActivity extends AppCompatActivity {
    ArrayList<String> list=new ArrayList<>();
    ArrayList<View> views=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<10;i++){
            list.add("test"+i);
        }
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) viewPager.getLayoutParams();
        params.width= CommonUtils.getScreenWidth(this)-CommonUtils.dp2px(this,80);
        params.setMargins(CommonUtils.dp2px(this,16),CommonUtils.dp2px(this,20+16),CommonUtils.dp2px(this,16),CommonUtils.dp2px(this,20+16));
        viewPager.setLayoutParams(params);
        viewPager.setPageMargin(CommonUtils.dp2px(this,8));

        for(int i=0;i<list.size(); i++){
            CardView cardView= (CardView) LayoutInflater.from(this).inflate(R.layout.cardview_item,null,false);
            TextView textView=(TextView) cardView.findViewById(R.id.tv_name);
            textView.setText(list.get(i));
            cardView.setTag(textView);
            views.add(cardView);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,"000",0).show();
                }
            });
        }
        FlipViewPaper flipViewPaper=new FlipViewPaper(views);
        viewPager.setAdapter(flipViewPaper);
        viewPager.setOffscreenPageLimit(2);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
