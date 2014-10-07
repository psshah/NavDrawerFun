package com.psshah.navdrawerdemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {
    private FragmentNavigationDrawer dlDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dlDrawer = (FragmentNavigationDrawer) findViewById(R.id.drawer_layout);
        dlDrawer.setupDrawerConfiguration((ListView) findViewById(R.id.lvDrawer), 
                R.layout.drawer_nav_item, R.id.flContent);

        dlDrawer.addNavItem("First", R.drawable.ic_one, "First Fragment", FirstFragment.class);
        dlDrawer.addNavItem("Second", R.drawable.ic_two, "Second Fragment", SecondFragment.class);
        dlDrawer.addNavItem("Third", R.drawable.ic_three, "Third Fragment", ThirdFragment.class);

        if (savedInstanceState == null) {
            dlDrawer.selectDrawerItem(0);   
        }
    }
    
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (dlDrawer.isDrawerOpen()) {
            // Uncomment to hide menu items                        
            //menu.findItem(R.id.mi_test).setVisible(false);
        }
    	return super.onPrepareOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (dlDrawer.getDrawerToggle().onOptionsItemSelected(item)) {
            return true;
        }
    	return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        dlDrawer.getDrawerToggle().syncState();
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
    	super.onConfigurationChanged(newConfig);
        dlDrawer.getDrawerToggle().onConfigurationChanged(newConfig);
    }
}
