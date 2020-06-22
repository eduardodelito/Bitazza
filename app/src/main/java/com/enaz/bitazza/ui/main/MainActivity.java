package com.enaz.bitazza.ui.main;

import android.os.Bundle;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.enaz.bitazza.R;
import com.enaz.bitazza.base.BaseActivity;
import com.enaz.bitazza.ui.login.LoginFragment;
import com.enaz.bitazza.ui.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity implements LoginFragment.OnLoginFragmentListener,
        SettingsFragment.OnSettingsFragmentListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
            navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            appBarConfiguration =
                    new AppBarConfiguration.Builder(navController.getGraph()).build();
            NavigationUI.setupWithNavController(bottomNavigationView, navController);
            showHideBottomNavigation(View.GONE);
        }
    }

    @Override
    public void login() {
        showHideBottomNavigation(View.VISIBLE);
        bottomNavigationView.setSelectedItemId(R.id.navigation_market);
    }

    @Override
    public void logout() {
        navController.navigate(R.id.navigation_login);
    }

    @Override
    public void hideNavBottom() {
        showHideBottomNavigation(View.GONE);
    }

    private void showHideBottomNavigation(int visibility) {
        bottomNavigationView.setVisibility(visibility);
    }
}
