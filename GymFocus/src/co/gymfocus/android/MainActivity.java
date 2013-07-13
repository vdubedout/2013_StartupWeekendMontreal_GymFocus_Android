
package co.gymfocus.android;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import co.gymfocus.android.adapter.ViewPagerAdapter;
import co.gymfocus.android.rest.RestClient;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.rest.RestService;

@EActivity(R.layout.activity_main)
public class MainActivity
    extends SherlockFragmentActivity
    implements OnPageChangeListener, TabListener
{

    @RestService
    RestClient restClient;
    private String[] locations;
    @ViewById
    ViewPager pager;

    @AfterViews
    void afterViews() {
        locations = getResources().getStringArray(R.array.locations);
        configureViewPager();
        configureActionBar();
    }

    @UiThread
    void doSomethingElseOnUiThread() {
        // do something on UIThread
    }

    @Background
    void doSomethingInBackground() {
        restClient.main();
        doSomethingElseOnUiThread();
    }

    private void configureViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), locations);
        pager.setAdapter(viewPagerAdapter);
        pager.setOnPageChangeListener(this);
    }

    public void onPageSelected(int position) {
        Tab tab = getSupportActionBar().getTabAt(position);
        getSupportActionBar().selectTab(tab);
    }

    private void configureActionBar() {
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (String location: locations) {
            Tab tab = getSupportActionBar().newTab();
            tab.setText(location);
            tab.setTabListener(this);
            getSupportActionBar().addTab(tab);
        }
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        int position = tab.getPosition();
        pager.setCurrentItem(position);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater();
        return true;
    }
    @Override
public void onPageScrollStateChanged(int position) {}@Override
 public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}@Override
 public void onTabUnselected(Tab tab, FragmentTransaction ft) {}@Override
public void onTabReselected(Tab tab, FragmentTransaction ft) {}
}
