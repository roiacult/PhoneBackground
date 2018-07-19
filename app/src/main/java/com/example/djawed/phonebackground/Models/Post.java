package com.example.djawed.phonebackground.Models;

import java.util.ArrayList;

public class Post {
    private String id,statut,userId;
    private ArrayList<String> likes,downloads;

    public Post ( String id , String statut , String userId ) {
        this.id = id;
        this.statut = statut;
        this.userId = userId;
    }

    public Post ( ) {
    }

//seters and getters////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getId ( ) {
        return id;
    }

    public void setId ( String id ) {
        this.id = id;
    }

    public String getStatut ( ) {
        return statut;
    }

    public void setStatut ( String statut ) {
        this.statut = statut;
    }

    public String getUserId ( ) {
        return userId;
    }

    public void setUserId ( String userId ) {
        this.userId = userId;
    }

    public ArrayList <String> getLikes ( ) {
        return likes;
    }

    public void setLikes ( ArrayList <String> likes ) {
        this.likes = likes;
    }

    public ArrayList <String> getDownloads ( ) {
        return downloads;
    }

    public void setDownloads ( ArrayList <String> downloads ) {
        this.downloads = downloads;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
