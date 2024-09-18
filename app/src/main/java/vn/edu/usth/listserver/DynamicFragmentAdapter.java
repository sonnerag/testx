package vn.edu.usth.listserver;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class DynamicFragmentAdapter extends FragmentStatePagerAdapter {
    private final int PAGE_COUNT = 10;
    private String titles[] = new String[] { "Hanoi", "Paris", "Toulouse", "Paris", "Toulouse", "Hanoi", "Paris", "Toulouse", "Paris", "Hanoi" };


    public DynamicFragmentAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public int getCount() {
        return PAGE_COUNT; // number of pages for a ViewPager
    }


    @Override
    public Fragment getItem(int page) {
        // returns an instance of Fragment corresponding to the specified page
        switch (page) {
            case 0: return new ListFragment();
            case 1: return new ListFragment();
            case 2: return new ListFragment();
            case 3: return new ListFragment();
            case 4: return new ListFragment();
            case 5: return new ListFragment();
            case 6: return new ListFragment();
            case 7: return new ListFragment();
            case 8: return new ListFragment();
            case 9: return new ListFragment();
        }
        return null;
    }


    @Override
    public CharSequence getPageTitle(int page) {
// returns a tab title corresponding to the specified page
        return titles[page];
    }
}
