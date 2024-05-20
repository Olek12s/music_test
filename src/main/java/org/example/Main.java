package org.example;

import java.util.Optional;

public class Main
{
    public static void main(String[] args)
    {
        Optional<Song> song = Song.Persistence.read(1);
        System.out.println(song.get().title());
    }
}

