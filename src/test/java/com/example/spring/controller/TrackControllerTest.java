package com.example.spring.controller;

import com.example.spring.entity.Track;
import com.example.spring.exception.EntityNotFoundException;
import com.example.spring.profiles.DefaultProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@DefaultProfile
class TrackControllerTest {
    @Autowired
    private TrackController trackController;

    @Test
    void findTracks() {
        ResponseEntity<List<Track>> response = trackController.findTracks();
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void findCoursesOfTrack() {
        ResponseEntity<List<String>> response = trackController.findCoursesOfTrack(1);
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertThrows(EntityNotFoundException.class, () -> trackController.findCoursesOfTrack(0));
    }

    @Test
    void findTracksWithCourse() {
        ResponseEntity<List<Track>> response = trackController.findTracksWithCourse("math");
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        response = trackController.findTracksWithCourse("chemistry");
        assertEquals(1, Objects.requireNonNull(response.getBody()).size());
        assertEquals(1, Objects.requireNonNull(response.getBody()).get(0).getId());
    }
}