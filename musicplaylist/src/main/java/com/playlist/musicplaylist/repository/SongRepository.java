package com.playlist.musicplaylist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.playlist.musicplaylist.model.Song;

public interface SongRepository extends JpaRepository<Song, Long> {

}