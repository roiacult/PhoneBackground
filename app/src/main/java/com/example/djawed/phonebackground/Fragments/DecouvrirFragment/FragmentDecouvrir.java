package com.example.djawed.phonebackground.Fragments.DecouvrirFragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.djawed.phonebackground.MainActivity;
import com.example.djawed.phonebackground.R;

public class FragmentDecouvrir extends Fragment {

    private Toolbar toolbar;
    private ViewPager pager;
    private ViewPagerAdapter pagerAdapter;
    private TabLayout tabLayout;
    private DrawerLayout drawer;
    private AlertDialog dialog;

    private DecouvrirViewModele viewModele;

    private MainActivity listner;


    public FragmentDecouvrir ( ) {
        // Required empty public constructor
    }

    @Override
    public void onAttach ( Context context ) {
        super.onAttach ( context );
        if(context instanceof MainActivity){
            listner = (MainActivity) context;
        }
    }

    @Override
    public void onDetach ( ) {
        listner =null;
        super.onDetach ( );
    }

    @Override
    public View onCreateView ( LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState ) {
        View v =inflater.inflate ( R.layout.fragment_decouvrir , container , false );

        viewModele = ViewModelProviders.of ( this ).get ( DecouvrirViewModele.class );
        toolbar = (Toolbar)v.findViewById ( R.id.decouvrir_toolbare );
        listner.setSupportActionBar ( toolbar );
        setHasOptionsMenu ( true );

        pagerAdapter = new ViewPagerAdapter ( getFragmentManager () );
        pager = (ViewPager) v.findViewById ( R.id.decouvrir_container );
        pager.setAdapter ( pagerAdapter);
        tabLayout = (TabLayout) v.findViewById ( R.id.decouvrir_tabs );

        tabLayout.addOnTabSelectedListener ( new TabLayout.ViewPagerOnTabSelectedListener ( pager ) );
        pager.addOnPageChangeListener ( new TabLayout.TabLayoutOnPageChangeListener ( tabLayout ) );

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle ( getActivity () , drawer , toolbar, R.string.navigation_drawer_open , R.string.navigation_drawer_close );
        drawer.addDrawerListener ( toggle );
        toggle.syncState ( );

        return v;
    }


    @Override
    public void onCreateOptionsMenu ( Menu menu , MenuInflater inflater ) {
        super.onCreateOptionsMenu ( menu , inflater );
        inflater.inflate ( R.menu.decouvrir_toolbare_menu,menu );
    }

    @Override
    public boolean onOptionsItemSelected ( MenuItem item ) {

        switch (item.getItemId ()){
            case R.id.decouvrir_menu_addfreind :
                dialog.show ();
                return true;
        }

        return false;
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter{

        public ViewPagerAdapter ( FragmentManager fm ) {
            super ( fm );
        }

        @Override
        public Fragment getItem ( int position ) {
            switch (position){
                case 0: return viewModele.getCategories ();

                case 1 : return  viewModele.getRecent ();

                case 2 : return viewModele.getMelanger ();
            }

            return null;
        }

        @Override
        public int getCount ( ) {
            return 3;
        }
    }

    public void setDrawer ( DrawerLayout drawer ) {
        this.drawer = drawer;
    }

    public void setDialog ( AlertDialog dialog ) {
        this.dialog = dialog;
    }
}
