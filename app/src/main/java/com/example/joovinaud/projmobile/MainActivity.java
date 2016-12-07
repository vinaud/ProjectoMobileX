package com.example.joovinaud.projmobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import layout.HelloFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    MenuItem item1;
    MenuItem item2;

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//ghghhggh

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
      //  drawer.setDrawerListener(toggle);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        sharedpreferences = getSharedPreferences("User", 0);

        Intent current = getIntent();
        if (current !=null && current.getStringExtra("Login") != null) {

            navigationView.getMenu().findItem(R.id.planos).setVisible(true);
            navigationView.getMenu().findItem(R.id.planosCad).setVisible(true);
            navigationView.getMenu().findItem(R.id.login).setVisible(false);

            View mHeaderView = navigationView.getHeaderView(0);
            TextView userMailHeader = (TextView) mHeaderView.findViewById(R.id.textView);
            userMailHeader.setText(current.getStringExtra("mail"));

            TextView userNameHeader = (TextView) mHeaderView.findViewById(R.id.headerName);
            userNameHeader.setText(sharedpreferences.getString("name",null) +" " + sharedpreferences.getString("sobrenome",null));
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, new HelloFragment());
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

   /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
   // @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        String title = null;

        if (id == R.id.login) {
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);


        } else if (id == R.id.planos) {
            fragment = new PlanosFragment();
            title  = "Meus Planos";
        } else if (id == R.id.planosCad) {
            fragment = new PlanosCadFragment();
            title  = "Cadastro de plano";
        } else if (id == R.id.mapa) {
            fragment = new MapFrag();
            title  = "Mapa";
        }

        else if (id == R.id.exer) {
            fragment = new ExerFragment();
            title  = "Exercicios";
            //Intent i = new Intent(this, ExerActivity.class);
           // startActivity(i);
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }

        // set the toolbar title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void teste(MenuItem item) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

  /*  @Override
    public void onFragmentInteraction(Uri uri) {
    }*/
}
