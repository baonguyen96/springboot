package com.example.spring.config;

import com.example.spring.entity.Track;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "tracks")
@Getter
@Setter
public class TrackConfig {
    private Track track1;
    private Track track2;

    public List<Track> getTracks() {
        return List.of(track1, track2);
    }
}
