package com.playlist.musicplaylist.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Collections;

import com.playlist.musicplaylist.model.Song;
import com.playlist.musicplaylist.repository.SongRepository;

@Service
public class SongService {

    private final SongRepository repository;

    public SongService(SongRepository repository){
        this.repository = repository;
    }

    // Add Song
    public Song addSong(Song song){
        return repository.save(song);
    }

    // Get All Songs
    public List<Song> getSongs(){
        return repository.findAll();
    }

    // Delete Song
    public void deleteSong(Long id){
        repository.deleteById(id);
    }

    // Shuffle Playlist
    public List<Song> shuffleSongs(){
        List<Song> songs = repository.findAll();
        Collections.shuffle(songs);
        return songs;
    }

}