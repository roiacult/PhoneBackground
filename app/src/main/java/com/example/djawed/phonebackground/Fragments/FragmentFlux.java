package com.example.djawed.phonebackground.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.djawed.phonebackground.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFlux extends Fragment {

    private Toolbar toolbar;


    public FragmentFlux ( ) {
        // Required empty public constructor
    }


    @Override
    public View onCreateView ( LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState ) {//flux_toolbar

        View v =inflater.inflate ( R.layout.fragment_flux , container , false );

        toolbar = (Toolbar) v.findViewById ( R.id.flux_toolbar );

        return v;
    }

    public Toolbar getToolbar ( ) {
        return toolbar;
    }
}
