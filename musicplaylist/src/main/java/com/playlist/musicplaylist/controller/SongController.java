package com.playlist.musicplaylist.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.playlist.musicplaylist.model.Song;
import com.playlist.musicplaylist.service.SongService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class SongController {

    private final SongService service;

    public SongController(SongService service){
        this.service = service;
    }

    // Get all songs
    @GetMapping("/songs")
    public List<Song> getSongs(){
        return service.getSongs();
    }

    // Add song
    @PostMapping("/add")
    public Song addSong(@RequestBody Song song){
        return service.addSong(song);
    }

    // Delete song
    @DeleteMapping("/delete/{id}")
    public void deleteSong(@PathVariable Long id){
        service.deleteSong(id);
    }

    // Shuffle playlist
    @GetMapping("/shuffle")
    public List<Song> shuffleSongs(){
        return service.shuffleSongs();
    }
}