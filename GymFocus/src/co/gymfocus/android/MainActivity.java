package co.gymfocus.android;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends SherlockFragmentActivity implements
		OnPageChangeListener, TabListener {

	private String[] locations;
	private String[] mMenuList;

	@ViewById(R.id.left_drawer)
	ListView mleftDrawerList;

	@ViewById(R.id.drawer_layout)
	DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;

	@AfterViews
	void afterViews() {
		mMenuList = getResources().getStringArray(R.array.SlideMenu);
		configureSlideDrawer();
		// configureActionBar();
	}

	private void configureSlideDrawer() {
		mleftDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, mMenuList));
		mleftDrawerList.setOnItemClickListener(new DrawerItemClickListener());
		mDrawerToggle = new ActionBarDrawerToggle(this, 
				mDrawerLayout, 
				drawerImageRes, 
				openDrawerContentDescRes, 
				closeDrawerContentDescRes);
		
	}

	private void configureActionBar() {
		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		for (String location : locations) {
			Tab tab = getSupportActionBar().newTab();
			tab.setText(location);
			tab.setTabListener(this);
			getSupportActionBar().addTab(tab);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater();
		return true;
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int arg0) {

	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}

	}

	private void selectItem(int position) {
		SherlockFragment fragment = getPageFragment(mMenuList[position]);
		FragmentManager supportFragmentManager = getSupportFragmentManager();
		supportFragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment).commit();
		mleftDrawerList.setItemChecked(position, true);
		setTitle(mMenuList[position]);
		mDrawerLayout.closeDrawer(mleftDrawerList);
	}

	private SherlockFragment getPageFragment(String menu) {
		if (menu.equalsIgnoreCase(getString(R.string.menulist_accounts))) {
			return new FragmentAccount();
		} else if (menu.equalsIgnoreCase(getString(R.string.menulist_messages))) {
			return new FragmentMessages();
		} else if (menu
				.equalsIgnoreCase(getString(R.string.menulist_schedules))) {
			return new FragmentSchedules();
		} else {
			return new FragmentWorkouts();
		}
	}
}
