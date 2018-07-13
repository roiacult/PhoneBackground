package com.example.djawed.phonebackground.Fragments.DecouvrirFragment;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.djawed.phonebackground.R;

public class FragmentDecouvrir extends Fragment {

    private Toolbar toolbar;
    private ViewPager pager;
    private ViewPagerAdapter pagerAdapter;
    private TabLayout tabLayout;

    private DecouvrirViewModele viewModele;


    public FragmentDecouvrir ( ) {
        // Required empty public constructor
    }



    @Override
    public View onCreateView ( LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState ) {
        View v =inflater.inflate ( R.layout.fragment_decouvrir , container , false );

        viewModele = ViewModelProviders.of ( this ).get ( DecouvrirViewModele.class );
        toolbar = (Toolbar)v.findViewById ( R.id.decouvrir_toolbare );
        pagerAdapter = new ViewPagerAdapter ( getFragmentManager () );
        pager = (ViewPager) v.findViewById ( R.id.decouvrir_container );
        pager.setAdapter ( pagerAdapter);
        tabLayout = (TabLayout) v.findViewById ( R.id.decouvrir_tabs );

        tabLayout.addOnTabSelectedListener ( new TabLayout.ViewPagerOnTabSelectedListener ( pager ) );
        pager.addOnPageChangeListener ( new TabLayout.TabLayoutOnPageChangeListener ( tabLayout ) );



        return v;
    }

    public Toolbar getToolbar(){return toolbar;}


    @Override
    public void onCreateOptionsMenu ( Menu menu , MenuInflater inflater ) {
        super.onCreateOptionsMenu ( menu , inflater );
        inflater.inflate ( R.menu.decouvrir_main,menu );
    }

    @Override
    public boolean onOptionsItemSelected ( MenuItem item ) {

        switch (item.getItemId ()){

        }

        return super.onOptionsItemSelected ( item );
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
}
