package com.example.djawed.phonebackground.Fragments.DecouvrirFragment;

import android.arch.lifecycle.ViewModel;

import com.example.djawed.phonebackground.Fragments.DecouvrirFragment.Fragments.DecouvrirCategoriesFragment;
import com.example.djawed.phonebackground.Fragments.DecouvrirFragment.Fragments.DecouvrirMelangerFragment;
import com.example.djawed.phonebackground.Fragments.DecouvrirFragment.Fragments.DecouvrirRecentFragment;

public class DecouvrirViewModele extends ViewModel {

    private DecouvrirCategoriesFragment categories;
    private DecouvrirRecentFragment recent;
    private DecouvrirMelangerFragment melanger;

    public DecouvrirCategoriesFragment getCategories ( ) {
        if(categories == null) categories = new DecouvrirCategoriesFragment ();
        return categories;
    }

    public DecouvrirRecentFragment getRecent ( ) {
        if(recent == null) recent = new DecouvrirRecentFragment ();
        return recent;
    }

    public DecouvrirMelangerFragment getMelanger ( ) {
        if(melanger == null) melanger = new DecouvrirMelangerFragment ();
        return melanger;
    }
}
