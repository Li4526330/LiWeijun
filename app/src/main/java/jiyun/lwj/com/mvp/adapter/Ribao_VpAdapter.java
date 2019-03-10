package jiyun.lwj.com.mvp.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 她说 on 2019/3/10.
 */

public class Ribao_VpAdapter extends FragmentPagerAdapter {
    private final ArrayList<Fragment> mFragments;
    private final ArrayList<String> mTitle;

    public Ribao_VpAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> title) {
        super(fm);
        mFragments = fragments;
        mTitle = title;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
