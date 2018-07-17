package com.example.djawed.phonebackground.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.djawed.phonebackground.R;


public class FragmentProfile extends Fragment {

    private Toolbar toolbar;

    public FragmentProfile ( ) {
        // Required empty public constructor
    }



    @Override
    public View onCreateView ( LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        View v = inflater.inflate ( R.layout.fragment_profile , container , false );

        toolbar = (Toolbar) v.findViewById ( R.id.profile_toolbare );

        return v;
    }

}
