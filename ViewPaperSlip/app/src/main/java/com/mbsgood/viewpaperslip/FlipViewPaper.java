package com.mbsgood.viewpaperslip;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/*
* User: ChenCHaoXue
* Create date: 2017-03-10 
* Time: 15:54 
* From VCard
*/
public class FlipViewPaper extends PagerAdapter {
    private List<View> mViewList;

    public FlipViewPaper(List<View> mViewList) {
        this.mViewList = mViewList;
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mViewList.get(position);
        if (view.getParent() != null) {
            container.removeView(view);
        }
        container.addView(view);
        return mViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(mViewList.get(position));
    }
}
