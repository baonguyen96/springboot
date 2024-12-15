package com.example.spring.service.impl;

import com.example.spring.config.TrackConfig;
import com.example.spring.entity.Track;
import com.example.spring.exception.EntityNotFoundException;
import com.example.spring.service.TrackService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrackServiceImpl implements TrackService {
    private final TrackConfig trackConfig;

    public TrackServiceImpl(TrackConfig trackConfig) {
        this.trackConfig = trackConfig;
    }

    @Override
    public List<Track> findAll() {
        return trackConfig.getTracks();
    }

    @Override
    public List<String> findCoursesOfTrack(int trackId) {
        Optional<Track> track = trackConfig.getTracks().stream().filter(t -> t.getId() == trackId).findFirst();

        if (track.isPresent()) {
            return track.get().getCourses();
        }

        throw new EntityNotFoundException("Cannot find such track with ID: " + trackId);
    }

    @Override
    public List<Track> findTracksWithCourse(String course) {
        return findAll().stream().filter(track -> track.getCourses().contains(course)).collect(Collectors.toList());
    }
}
