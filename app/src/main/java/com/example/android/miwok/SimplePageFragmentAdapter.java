package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Daguru34 on 3/25/2017.
 */

public class SimplePageFragmentAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private Context mContext;

    public SimplePageFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext=context;
    }

        @Override
        public Fragment getItem(int position){

            if (position == 0) {
                return new ColorsFragment();
            } else if (position == 1) {
                return new FamilyFragment();
            } else if (position == 2) {
                return new NumbersFragment();
            } else {
                return new PhrasesFragment();
            }
        }
    @Override
    public int getCount() {
        //return 4;
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_numbers);
        } else if (position == 1) {
            return mContext.getString(R.string.category_family);
        } else if (position == 2) {
            return mContext.getString(R.string.category_colors);
        } else {
            return mContext.getString(R.string.category_phrases);
        }
    }
}
