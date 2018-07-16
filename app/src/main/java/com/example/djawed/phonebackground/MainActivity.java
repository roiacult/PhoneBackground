package com.example.djawed.phonebackground;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.djawed.phonebackground.Fragments.DecouvrirFragment.FragmentDecouvrir;
import com.example.djawed.phonebackground.Fragments.FragmentFlux;
import com.example.djawed.phonebackground.Fragments.FragmentTransferer;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    private BottomNavigationView navigation;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    private FragmentsViewModele viewModele;
    private FragmentManager manager;




    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        //Toolbar toolbar = (Toolbar) findViewById ( R.id.toolbar );
        //setSupportActionBar ( toolbar );

        viewModele = ViewModelProviders.of ( this ).get ( FragmentsViewModele.class );
        manager = getSupportFragmentManager ();

        drawer = (DrawerLayout) findViewById ( R.id.drawer_layout );

        navigation = (BottomNavigationView) findViewById ( R.id.navigation );
        navigation.setOnNavigationItemSelectedListener ( mOnNavigationItemSelectedListener );

        navigation.setSelectedItemId ( R.id.bottom_navigation_decouvrir );



        NavigationView navigationView = (NavigationView) findViewById ( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener ( this );


    }

    @Override
    public void onBackPressed ( ) {
        DrawerLayout drawer = (DrawerLayout) findViewById ( R.id.drawer_layout );
        if ( drawer.isDrawerOpen ( GravityCompat.START ) ) {
            drawer.closeDrawer ( GravityCompat.START );
        } else {
            super.onBackPressed ( );
        }
    }

    @Override
    public boolean onCreateOptionsMenu ( Menu menu ) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ( ).inflate ( R.menu.main , menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected ( MenuItem item ) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ( );

        //noinspection SimplifiableIfStatement
        if ( id == R.id.action_settings ) {
            return true;
        }

        return super.onOptionsItemSelected ( item );
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected ( MenuItem item ) {
        // Handle navigation view item clicks here.
        int id = item.getItemId ( );

        if ( id == R.id.nav_camera ) {
            // Handle the camera action
        } else if ( id == R.id.nav_gallery ) {

        } else if ( id == R.id.nav_slideshow ) {

        } else if ( id == R.id.nav_manage ) {

        } else if ( id == R.id.nav_share ) {

        } else if ( id == R.id.nav_send ) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById ( R.id.drawer_layout );
        drawer.closeDrawer ( GravityCompat.START );
        return true;
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener ( ) {

        @Override
        public boolean onNavigationItemSelected ( @NonNull MenuItem item ) {

            switch (item.getItemId ( )) {
                case R.id.bottom_navigation_flux:

                    FragmentFlux flux = viewModele.getFlux ();
                    manager.beginTransaction ().replace ( R.id.container ,flux).commit ();
                    toggle = new ActionBarDrawerToggle ( MainActivity.this,drawer,flux.getToolbar (),R.string.navigation_drawer_open , R.string.navigation_drawer_close );
                    drawer.addDrawerListener ( toggle );
                    toggle.syncState ();
                    return true;


                case R.id.bottom_navigation_decouvrir:

                    FragmentDecouvrir decouvrir = viewModele.getDecouvrir ();

                        manager.beginTransaction ( ).replace ( R.id.container , decouvrir ).commit ( );

                    toggle = new ActionBarDrawerToggle ( MainActivity.this , drawer , decouvrir.getToolbar ( ) , R.string.navigation_drawer_open , R.string.navigation_drawer_close );
                        drawer.addDrawerListener ( toggle );
                        toggle.syncState ( );

                    return true;


                case R.id.bottom_navigation_transferer:

                    FragmentTransferer transferer=viewModele.getTransferer ();
                    manager.beginTransaction ().replace ( R.id.container,transferer ).commit ();
                    toggle = new ActionBarDrawerToggle ( MainActivity.this , drawer , transferer.getToolbar () , R.string.navigation_drawer_open , R.string.navigation_drawer_close );
                    drawer.addDrawerListener ( toggle );
                    toggle.syncState ();
                    return true;


                case R.id.bottom_navigation_activites :

                    manager.beginTransaction ().replace ( R.id.container,viewModele.getActivites () ).commit ();
                    return true;


                case R.id.bottom_navigation_profile :

                    manager.beginTransaction ().replace ( R.id.container,viewModele.getProfile () ).commit ();
                    return true;
            }
            return false;
        }
    };
}
