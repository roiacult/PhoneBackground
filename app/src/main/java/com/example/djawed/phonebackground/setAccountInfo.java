package com.example.djawed.phonebackground;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.example.djawed.phonebackground.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class setAccountInfo extends AppCompatActivity {

    private DatabaseReference reference;

    private CircleImageView mImage;
    private TextView mName;
    private EditText mUserName;
    private Button mSubmit;
    private TextView mEmail;
    private ProgressBar mPprogressBar;

    private String  imgUrl;
    private String id ;
    private String name ;
    private String email;


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_set_account_info );

        mImage = (CircleImageView) findViewById ( R.id.setacountinfo_circleimg );
        mName = (TextView) findViewById ( R.id.setacountinfo_user_fullName );
        mSubmit = (Button) findViewById ( R.id.setacountinfo_submitInfo );
        mUserName = (EditText) findViewById ( R.id.setacountinfo_edittText );
        mEmail = (TextView) findViewById ( R.id.setacountinfo_email );
        mPprogressBar = (ProgressBar) findViewById ( R.id.progressBar );
        reference = FirebaseDatabase.getInstance ().getReference ().child ( "users" );

        imgUrl  = getIntent ().getStringExtra ( MainActivity.ACOUNT_INFO_PROFILE_IMGURI );
        id = getIntent ().getStringExtra ( MainActivity.ACOUNT_INFO_ID );
        name = getIntent ().getStringExtra ( MainActivity.ACOUNT_INFO_NAME );
        email = getIntent ().getStringExtra ( MainActivity.ACOUNT_INFO_EMAIL );

        Picasso.get ().load ( imgUrl ).into ( mImage );
        mName.setText ( name );
        mEmail.setText ( email );


        mSubmit.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                String userName = mUserName.getText ().toString ();
                if( TextUtils.isEmpty ( userName )){
                    mUserName.setError ( "Entrer votre nom d'utilisateur s'il vous plait" );
                    mUserName.requestFocus ();
                    return;
                }

                mPprogressBar.setVisibility ( View.VISIBLE );
                mUserName.setVisibility ( View.VISIBLE );

                User user = new User ( id,name,userName,email,imgUrl );
                reference.child ( id ).setValue ( user ).addOnCompleteListener ( new OnCompleteListener <Void> ( ) {
                    @Override
                    public void onComplete ( @NonNull Task<Void> task ) {
                        if(task.isSuccessful ()){
                            finish ();
                        }else{
                            mPprogressBar.setVisibility ( View.GONE );
                            mUserName.setVisibility ( View.VISIBLE );
                            Toast.makeText ( setAccountInfo.this,"failled in saving informations",Toast.LENGTH_SHORT ).show ();
                        }
                    }
                } );
            }
        } );

    }
}
