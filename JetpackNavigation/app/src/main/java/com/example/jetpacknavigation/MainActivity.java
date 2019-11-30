package com.example.jetpacknavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public Toolbar toolbar;
    public DrawerLayout drawerLayout;
    public NavController navController;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpNavigation();

    }

    public void setUpNavigation(){
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);

        navController = Navigation.findNavController(this,R.id.hostFragment);

        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
        NavigationUI.setupWithNavController(navigationView,navController);

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();

        }

    }


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(Navigation.findNavController(this,R.id.hostFragment),drawerLayout);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        menuItem.setCheckable(true); //to highlight the fragments
        drawerLayout.closeDrawers();

        int id = menuItem.getItemId();

        switch (id){
            case R.id.firstFragment:
                Toast.makeText(getApplicationContext(),"first clicked",Toast.LENGTH_LONG).show();
                navController.navigate(R.id.firstFragment2);
                break;
            case R.id.secondFragment:
                Toast.makeText(getApplicationContext(),"second clicked",Toast.LENGTH_LONG).show();
                navController.navigate(R.id.secondFragment2);
                break;

            case R.id.thirdFragment:
                Toast.makeText(getApplicationContext(),"third clicked",Toast.LENGTH_LONG).show();
                navController.navigate(R.id.thirdFragment2);
                break;
        }


        return true;
    }
}
