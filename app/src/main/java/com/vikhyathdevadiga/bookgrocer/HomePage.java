package com.vikhyathdevadiga.bookgrocer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.vikhyathdevadiga.bookgrocer.Fragments.HomeFragment;
import com.vikhyathdevadiga.bookgrocer.Fragments.SearchFragment;
import com.vikhyathdevadiga.bookgrocer.Fragments.UserProfile;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    public static BottomNavigationView bottomNav;
    public static DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bottomNav = findViewById(R.id.bottom_navigation);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        naviagtionDrawer();


    }

    private void naviagtionDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case  R.id.nav_home:
                break;

            case  R.id.nav_our_books:
                break;

            case  R.id.nav_our_stores:
                break;

            case  R.id.nav_careers:
                break;

            default:
                break;
        }
        return true;

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selected = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selected = new HomeFragment();
                            break;

                        case R.id.nav_product_Search:
                            selected = new SearchFragment();
                            break;

                        case R.id.nav_whishlist:
                            selected = new SearchFragment();
                            break;

                        case R.id.nav_user_cart:
                            selected = new UserProfile();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selected).commit();
                    return true;
                }
            };

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        }
        else
            super.onBackPressed();
    }
}
