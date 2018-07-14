package com.example.djawed.phonebackground.Fragments.DecouvrirFragment.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.djawed.phonebackground.R;


public class DecouvrirCategoriesFragment extends Fragment {

    public DecouvrirCategoriesFragment ( ) {

    }


    @Override
    public View onCreateView ( LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        return inflater.inflate ( R.layout.fragment_decouvrir_categories , container , false );
    }

}
