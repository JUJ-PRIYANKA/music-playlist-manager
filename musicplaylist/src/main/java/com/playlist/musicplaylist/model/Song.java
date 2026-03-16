package com.playlist.musicplaylist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String songName;
    private String artist;
    private String duration;

    public Song(){}

    public Long getId(){
        return id;
    }

    public String getSongName(){
        return songName;
    }

    public void setSongName(String songName){
        this.songName = songName;
    }

    public String getArtist(){
        return artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public String getDuration(){
        return duration;
    }

    public void setDuration(String duration){
        this.duration = duration;
    }
}