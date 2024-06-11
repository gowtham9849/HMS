package com.Medical.MEmergency.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.maps.GeoApiContext;

@Configuration
public class GeoApiContextConfig {

    @Bean
    public GeoApiContext geoApiContext() {
        return new GeoApiContext.Builder()
                .apiKey("YOUR_GOOGLE_MAPS_API_KEY")
                .build();
    }
}
