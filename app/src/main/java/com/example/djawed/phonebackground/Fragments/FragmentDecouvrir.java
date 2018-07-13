package com.example.djawed.phonebackground.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.djawed.phonebackground.R;

public class FragmentDecouvrir extends Fragment {

    private Toolbar toolbar;


    public FragmentDecouvrir ( ) {
        // Required empty public constructor
    }



    @Override
    public View onCreateView ( LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState ) {
        View v =inflater.inflate ( R.layout.fragment_decouvrir , container , false );

        toolbar = (Toolbar)v.findViewById ( R.id.decouvrir_toolbare );

        return v;
    }

    public Toolbar getToolbar(){return toolbar;}


}
