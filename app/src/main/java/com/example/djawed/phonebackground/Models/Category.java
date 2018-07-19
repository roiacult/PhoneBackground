package com.example.djawed.phonebackground.Models;

import java.util.ArrayList;

public class Category {

    private String name;
    private ArrayList<String> posts;

    public Category ( String name ) {
        this.name = name;
    }

    public Category ( ) {
    }


//setters and getters  ///////////////////////////////////////////////////////////////////////////////////
    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public ArrayList <String> getPosts ( ) {
        return posts;
    }

    public void setPosts ( ArrayList <String> posts ) {
        this.posts = posts;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////


}
