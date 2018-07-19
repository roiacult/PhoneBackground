package com.example.djawed.phonebackground.Models;

import java.util.ArrayList;

public class User {

    private String id,name,userName,email,acceuil,biographie,profileImg,coverImg;
    private ArrayList<String> posts,postsLiked,followors,following,notifications,unReadNotifications;

    public User ( String id , String name , String userName , String email , String profileImg ) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.profileImg = profileImg;
    }

    public User ( ) {
    }

///seters and getters////////////////////////////////////////////////////////////////////////////////////

    public String getId ( ) {
        return id;
    }

    public void setId ( String id ) {
        this.id = id;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getUserName ( ) {
        return userName;
    }

    public void setUserName ( String userName ) {
        this.userName = userName;
    }

    public String getEmail ( ) {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getAcceuil ( ) {
        return acceuil;
    }

    public void setAcceuil ( String acceuil ) {
        this.acceuil = acceuil;
    }

    public String getBiographie ( ) {
        return biographie;
    }

    public void setBiographie ( String biographie ) {
        this.biographie = biographie;
    }

    public String getProfileImg ( ) {
        return profileImg;
    }

    public void setProfileImg ( String profileImg ) {
        this.profileImg = profileImg;
    }

    public String getCoverImg ( ) {
        return coverImg;
    }

    public void setCoverImg ( String coverImg ) {
        this.coverImg = coverImg;
    }

    public ArrayList <String> getPosts ( ) {
        return posts;
    }

    public void setPosts ( ArrayList <String> posts ) {
        this.posts = posts;
    }

    public ArrayList <String> getPostsLiked ( ) {
        return postsLiked;
    }

    public void setPostsLiked ( ArrayList <String> postsLiked ) {
        this.postsLiked = postsLiked;
    }

    public ArrayList <String> getFollowors ( ) {
        return followors;
    }

    public void setFollowors ( ArrayList <String> followors ) {
        this.followors = followors;
    }

    public ArrayList <String> getFollowing ( ) {
        return following;
    }

    public void setFollowing ( ArrayList <String> following ) {
        this.following = following;
    }

    public ArrayList <String> getNotifications ( ) {
        return notifications;
    }

    public void setNotifications ( ArrayList <String> notifications ) {
        this.notifications = notifications;
    }

    public ArrayList <String> getUnReadNotifications ( ) {
        return unReadNotifications;
    }

    public void setUnReadNotifications ( ArrayList <String> unReadNotifications ) {
        this.unReadNotifications = unReadNotifications;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
