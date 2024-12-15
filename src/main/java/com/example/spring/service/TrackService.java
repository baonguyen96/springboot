package com.example.spring.service;

import com.example.spring.entity.Track;

import java.util.List;

public interface TrackService {
    List<Track> findAll();
    List<String> findCoursesOfTrack(int trackId);
    List<Track> findTracksWithCourse(String course);
}
