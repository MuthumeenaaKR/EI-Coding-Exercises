
package com.eicoding.exercise1.structural.adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        System.out.println("--- Adapter Demo: Media Player ---");
        MediaPlayer mp3Player = new MediaAdapter("mp3");
        MediaPlayer mp4Player = new MediaAdapter("mp4");
        mp3Player.play("mp3", "song.mp3");
        mp4Player.play("mp4", "movie.mp4");
    }
}
