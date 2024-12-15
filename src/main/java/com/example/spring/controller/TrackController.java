package com.example.spring.controller;

import com.example.spring.entity.Track;
import com.example.spring.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class TrackController {
    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/tracks/all")
    public ResponseEntity<List<Track>> findTracks() {
        List<Track> tracks = this.trackService.findAll();
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    @GetMapping("/tracks/{id}/courses")
    public ResponseEntity<List<String>> findCoursesOfTrack(@PathVariable int id) {
        List<String> courses = this.trackService.findCoursesOfTrack(id);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> findTracksWithCourse(@PathParam("course") String course) {
        List<Track> tracks = this.trackService.findTracksWithCourse(course);
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }
}
