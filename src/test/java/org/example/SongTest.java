package org.example;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SongTest
{
    @Test
    public void testIfSongExists()
    {
        Optional<Song> result = Song.Persistence.read(7);
        Song song = result.get();
        assertTrue(song.equals(new Song(7, "The Doors", "Light My Fire", 426)));
    }
}