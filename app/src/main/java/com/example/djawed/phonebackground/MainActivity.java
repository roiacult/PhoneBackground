package com.example.djawed.phonebackground;

import android.arch.lifecycle.ViewModelProviders;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.djawed.phonebackground.Fragments.DecouvrirFragment.FragmentDecouvrir;
import com.example.djawed.phonebackground.Fragments.FragmentFlux;
import com.example.djawed.phonebackground.Fragments.FragmentTransferer;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.SignInButtonImpl;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String DRAWER_KEY="drawerKey";
    private static final int RC_SIGN_IN = 111;

    //Firebase instance
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseAuth.AuthStateListener mAuthListner  =new FirebaseAuth.AuthStateListener ( ) {
        @Override
        public void onAuthStateChanged ( @NonNull FirebaseAuth firebaseAuth ) {

            navigation.setSelectedItemId ( R.id.bottom_navigation_decouvrir );
            mUser = firebaseAuth.getCurrentUser ();

            if(mUser!= null){
                //the user alredy signe in so we shoud show the navigation bottom
                navigation.setVisibility ( View.VISIBLE );
            }else{
                //the user is not signe is so we shoud make the navigation bottom invisible and show only decouvrir fragment
                //and show a popup menu for signe in
                navigation.setVisibility ( View.GONE );
                dialog.show ();
            }
        }
    };;


    //views instance
    private BottomNavigationView navigation;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private AlertDialog dialog;
    private AlertDialog.Builder dialogBuilder;
    private ImageButton mFbBtn;
    private ImageButton mGoogleBtn;
    private ProgressBar progress;


    //other instance
    private FragmentsViewModele viewModele;
    private FragmentManager manager;

    //Google SigneIn instance
    private GoogleSignInOptions gso;
    private GoogleApiClient mGoogleApiClient;





    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );



        //For signe in with google
        configureApi ();
        ///////////////////

        //initialise obejects

        viewModele = ViewModelProviders.of ( this ).get ( FragmentsViewModele.class );
        manager = getSupportFragmentManager ();
        drawer = (DrawerLayout) findViewById ( R.id.drawer_layout );
        navigation = (BottomNavigationView) findViewById ( R.id.navigation );
        navigation.setOnNavigationItemSelectedListener ( mOnNavigationItemSelectedListener );
        //AlertDialogue for signeIn popupWindow
        dialogBuilder = new AlertDialog.Builder ( this );
        dialogBuilder.setTitle ( R.string.se_connecter );
        View v = getLayoutInflater ().inflate ( R.layout.popup_for_sginein,null );
        mFbBtn = (ImageButton) v.findViewById ( R.id.popup_fb );
        mGoogleBtn= (ImageButton) v.findViewById ( R.id.popup_google );
        progress = (ProgressBar) v.findViewById ( R.id.popup_progressBar );
        dialogBuilder.setView ( v );
        dialogBuilder.setNegativeButton ( R.string.fermer,null );
        dialog = dialogBuilder.create ();


        mGoogleBtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                progress.setVisibility ( View.VISIBLE );
                signeInWithGoogle();
            }
        } );

        mFbBtn.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                signInWithFacebook();
            }
        } );

        progress.setVisibility ( View.GONE );




        NavigationView navigationView = (NavigationView) findViewById ( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener ( this );


    }

    private void signInWithFacebook ( ) {
        //TODO implement this methode
    }

    private void signeInWithGoogle ( ) {
        Intent signInIntent =Auth.GoogleSignInApi.getSignInIntent ( mGoogleApiClient );
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult ( int requestCode , int resultCode , Intent data ) {
        super.onActivityResult ( requestCode , resultCode , data );

        //don't worry it's just some boiller stuff for signeIn using google acounts
        //copie and paste from stackOverflow

        if(requestCode == RC_SIGN_IN){

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent ( data );

            if(result.isSuccess ()){
                GoogleSignInAccount account = result.getSignInAccount ();
                AuthCredential credential = GoogleAuthProvider.getCredential ( account.getIdToken (),null );
                mAuth.signInWithCredential ( credential );
                dialog.dismiss ();
            }else {
                Toast.makeText ( this,"Signe In Failled",Toast.LENGTH_SHORT ).show ();
            }
            progress.setVisibility ( View.GONE );
        }
    }


    //we must call this methode in order to signe in with google

    private void configureApi(){

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder ( this )
                    .enableAutoManage ( this,null )
                    .addApi ( Auth.GOOGLE_SIGN_IN_API,gso ).build ();

    }

    @Override
    protected void onStart ( ) {
        super.onStart ( );
        mAuth = FirebaseAuth.getInstance ();
        mUser = mAuth.getCurrentUser ();
        mAuth.addAuthStateListener ( mAuthListner );
    }

    @Override
    protected void onStop ( ) {
        super.onStop ( );
        mAuth.removeAuthStateListener ( mAuthListner );
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

    public DrawerLayout getDrawer ( ) {
        return drawer;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener ( ) {

        @Override
        public boolean onNavigationItemSelected ( @NonNull MenuItem item ) {

            switch (item.getItemId ( )) {
                case R.id.bottom_navigation_flux:

                    FragmentFlux flux = viewModele.getFlux ();
                    //Send the drawerLayout to the fragment to enable toggle btn
                    flux.setDrawer ( drawer );
                    manager.beginTransaction ().replace ( R.id.container ,flux).commit ();
                    return true;


                case R.id.bottom_navigation_decouvrir:

                    FragmentDecouvrir decouvrir = viewModele.getDecouvrir ();
                    decouvrir.setDrawer ( drawer );
                    decouvrir.setDialog ( dialog );
                    manager.beginTransaction ( ).replace ( R.id.container , decouvrir ).commit ( );
                    return true;


                case R.id.bottom_navigation_transferer:

                    FragmentTransferer transferer=viewModele.getTransferer ();
                    transferer.setDrawer ( drawer );
                    manager.beginTransaction ().replace ( R.id.container,transferer ).commit ();
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
