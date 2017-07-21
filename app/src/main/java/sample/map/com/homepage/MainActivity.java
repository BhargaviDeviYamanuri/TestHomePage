package sample.map.com.homepage;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener {

    private DrawerLayout mDrawerLayout;
    private Context mContext;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView mNavigationView;
    private ArrayList<MenuDTO> mOptions = new ArrayList<>();
    private ListView mDrawerOptions;
    private CustomPagerAdapter mCustomPagerAdapter;
    private ViewPager mViewPager,fragmentPager;
    private Handler handler;
    private final int delay = 2000;
    private int page = 0;
    private TabLayout tabLayout;
    private TextView tabOne,tabTwo,tabThree;
    Runnable runnable = new Runnable() {
        public void run() {
            if (mCustomPagerAdapter.getCount() == page) {
                page = 0;
            } else {
                page++;
            }
            mViewPager.setCurrentItem(page, true);
            handler.postDelayed(this, delay);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        android.support.v7.widget.Toolbar mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        TextView mTitle = (TextView) findViewById(R.id.action_bar_title);
        mTitle.setText("Home");
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nvView);
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.closed);
        mDrawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.setDrawerIndicatorEnabled(false);
        drawerToggle.setHomeAsUpIndicator(R.drawable.ic_white_menu);
        drawerToggle.syncState();
        drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDrawerLayout.isDrawerVisible(mNavigationView)) {
                    mDrawerLayout.closeDrawer(mNavigationView);
                } else {
                    mDrawerLayout.openDrawer(mNavigationView);
                }
            }
        });
        mDrawerLayout.setDrawerListener(this);

        mOptions.add(new MenuDTO("Videos", "Meetup destination", R.drawable.select_video));
        mOptions.add(new MenuDTO("Images", "Get to know about us", R.drawable.select_image));
        mOptions.add(new MenuDTO("Milestones", "Change your preferences", R.drawable.select_milestone));
        mOptions.add(new MenuDTO("About us", "Help", R.drawable.about_us));

        mDrawerOptions = (ListView) findViewById(R.id.navList);
        MenuListAdapter menuListAdapter = new MenuListAdapter(this, mOptions);
        mDrawerOptions.setAdapter(menuListAdapter);
        mDrawerOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
        mCustomPagerAdapter = new CustomPagerAdapter(this);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                page = position;
                switch (position){
                    case 0:
                        radioGroup.check(R.id.radioButton1);
                        break;
                    case 1:
                        radioGroup.check(R.id.radioButton2);
                        break;
                    case 2:
                        radioGroup.check(R.id.radioButton3);
                        break;
                    case 3:
                        radioGroup.check(R.id.radioButton4);
                        break;
                    case 4:
                        radioGroup.check(R.id.radioButton5);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        fragmentPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(fragmentPager);
        fragmentPager.setOffscreenPageLimit(3);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(fragmentPager);
        setupTabIcons();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            int selectedTab = tab.getPosition();
                if(selectedTab == 0)
                {
                    tabOne.setTextColor(getResources().getColor(R.color.actionbar_clr));
                    tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.small_select_video, 0, 0);
                    tabLayout.getTabAt(0).setCustomView(tabOne);

                    tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.small_image, 0, 0);
                    tabTwo.setTextColor(getResources().getColor(R.color.tab_gray));
                    tabLayout.getTabAt(1).setCustomView(tabTwo);

                    tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.small_milestone, 0, 0);
                    tabThree.setTextColor(getResources().getColor(R.color.tab_gray));
                    tabLayout.getTabAt(2).setCustomView(tabThree);
                }else if (selectedTab == 1)
                {
                    tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.small_video, 0, 0);
                    tabLayout.getTabAt(0).setCustomView(tabOne);
                    tabOne.setTextColor(getResources().getColor(R.color.tab_gray));

                    tabTwo.setTextColor(getResources().getColor(R.color.actionbar_clr));
                    tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.small_select_image, 0, 0);
                    tabLayout.getTabAt(1).setCustomView(tabTwo);

                    tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.small_milestone, 0, 0);
                    tabLayout.getTabAt(2).setCustomView(tabThree);
                    tabThree.setTextColor(getResources().getColor(R.color.tab_gray));
                }else if (selectedTab == 2)
                {
                    tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.small_video, 0, 0);
                    tabLayout.getTabAt(0).setCustomView(tabOne);
                    tabOne.setTextColor(getResources().getColor(R.color.tab_gray));

                    tabTwo.setTextColor(getResources().getColor(R.color.tab_gray));
                    tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.small_image, 0, 0);
                    tabLayout.getTabAt(1).setCustomView(tabTwo);

                    tabThree.setTextColor(getResources().getColor(R.color.actionbar_clr));
                    tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.small_select_milestone, 0, 0);
                    tabLayout.getTabAt(2).setCustomView(tabThree);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupTabIcons() {
        tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("VIDEOS");
        tabOne.setTextColor(getResources().getColor(R.color.actionbar_clr));
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.small_select_video, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("IMAGES");
        tabTwo.setTextColor(getResources().getColor(R.color.tab_gray));
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.small_image, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("MILESTONE");
        tabThree.setTextColor(getResources().getColor(R.color.tab_gray));
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.small_milestone, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }

    private void setupViewPager(ViewPager viewPager) {
        FragPagerAdapter adapter = new FragPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new VideosFragment(), "VIDEOS");
        adapter.addFrag(new ImageFragment(), "Images");
        adapter.addFrag(new MilestoneFragment(), "MILESTONE");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {
        if (newState == DrawerLayout.STATE_IDLE && mDrawerLayout.isDrawerOpen(mNavigationView)) {
            mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, mNavigationView);
        }
    }
}
