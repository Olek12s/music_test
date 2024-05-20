package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest
{
    @Test
    public void isEmptyNewPlaylist()
    {
        Playlist pl = new Playlist();
        assertTrue(pl.isEmpty());
    }
    @Test
    public void isSizeOneAfterAddingFirstElement()
    {
        Playlist pl = new Playlist();
        pl.add(new Song(50, "Krawczyk", "Mój Przyjacielu", 700));
        assertTrue(pl.size() == 1);
    }

    @Test
    public void testIfAddedSongIsTheSame()
    {
        Playlist pl = new Playlist();
        Song s = new Song(50, "Krawczyk", "Mój Przyjacielu", 700);
        pl.add(s);
        assertEquals(s, pl.get(0));
    }

    @Test
    public void testIfAddedSongIsTheSame2()
    {
        Playlist pl = new Playlist();
        Song s = new Song(50, "Krawczcyk", "Mój przyjacielu", 700);
        pl.add(s);
        assertTrue(pl.size() == 1);
    }

}