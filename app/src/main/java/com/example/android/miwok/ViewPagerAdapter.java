package com.example.android.miwok;

 import android.support.v4.app.Fragment;
 import android.support.v4.app.FragmentManager;
 import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NumbersFragment();
            case 1:
                return new ColorsFragment();
            case 2:
                return new FamilyFragment();
            case 3:
                return new PhraseFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
