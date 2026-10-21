package com.playlismanager;

import java.util.Objects;

public record Song( String title ,  String artist ,  int durationSeconds) {
    public Song{
        Objects.requireNonNull(title, "title must be no null");
        Objects.requireNonNull(artist, "artist must be no null");

        if (!(durationSeconds>0)) {
            throw new IllegalArgumentException("duration must be greater then 0");
        }
    }
}
