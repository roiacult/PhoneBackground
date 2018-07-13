package com.example.djawed.phonebackground;

import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.Toolbar;

import com.example.djawed.phonebackground.Fragments.FragmentActivites;
import com.example.djawed.phonebackground.Fragments.DecouvrirFragment.FragmentDecouvrir;
import com.example.djawed.phonebackground.Fragments.FragmentFlux;
import com.example.djawed.phonebackground.Fragments.FragmentProfile;
import com.example.djawed.phonebackground.Fragments.FragmentTransferer;

public class FragmentsViewModele extends ViewModel {

    private FragmentDecouvrir decouvrir;
    private FragmentFlux flux;
    private FragmentTransferer transferer;
    private FragmentActivites activites;
    private FragmentProfile profile;

    private Toolbar toolbar;

    public FragmentDecouvrir getDecouvrir ( ) {
        if(decouvrir == null ) decouvrir = new FragmentDecouvrir ();
        return decouvrir;
    }
    public Toolbar getDecouvrirToolbare (){
        if(decouvrir == null ) decouvrir = new FragmentDecouvrir ();
        return decouvrir.getToolbar ();
    }

    public FragmentFlux getFlux ( ) {
        if(flux == null ) flux = new FragmentFlux ();
        return flux;
    }

    public Toolbar getFluxToolbare ( ) {
        if(flux == null ) flux = new FragmentFlux ();
        return flux.getToolbar ();
    }

    public FragmentTransferer getTransferer ( ) {
        if(transferer == null ) transferer = new FragmentTransferer ();
        return transferer;
    }

    public Toolbar getTransfererToolbare ( ) {
        if(transferer == null ) transferer = new FragmentTransferer ();
        return transferer.getToolbar ();
    }


    public FragmentActivites getActivites ( ) {
        if(activites == null ) activites = new FragmentActivites ();
        return activites;
    }

    public FragmentProfile getProfile ( ) {
        if(profile == null ) profile = new FragmentProfile ();
        return profile;
    }
}
