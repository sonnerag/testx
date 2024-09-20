package vn.edu.usth.listserver;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import vn.edu.usth.chatbox.RoomChat;

public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 10;
    private String titles[] = new String[] { "Hanoi", "Paris", "Toulouse", "Python", "C", "C#", "C++", "Rust", "Java", "HTML" };


    public HomeFragmentPagerAdapter(FragmentManager fm) {
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
            case 0: return new RoomChat();
            case 1: return new RoomChat();
            case 2: return new RoomChat();
            case 3: return new RoomChat();
            case 4: return new RoomChat();
            case 5: return new RoomChat();
            case 6: return new RoomChat();
            case 7: return new RoomChat();
            case 8: return new RoomChat();
            case 9: return new RoomChat();
        }
        return null;
    }


    @Override
    public CharSequence getPageTitle(int page) {
// returns a tab title corresponding to the specified page
        return titles[page];
    }
}
