package io.shardon.coronavirustracker.models;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LocationStatsTest {

    @Test
    void getState() {
        LocationStats locationStats = new LocationStats();
        locationStats.setState("test");
        assertEquals("test", locationStats.getState());
    }

    @Test
    void getCountry() {
        LocationStats locationStats = new LocationStats();
        locationStats.setCountry("test");
        assertEquals("test", locationStats.getCountry());
    }

    @Test
    void getLatestTotalCases() {
        LocationStats locationStats = new LocationStats();
        locationStats.setLatestTotalCases(1);
        assertEquals(1, locationStats.getLatestTotalCases());
    }

    @Test
    void getDiffFromPrevDay() {
        LocationStats locationStats = new LocationStats();
        locationStats.setDiffFromPrevDay(1);
        assertEquals(1, locationStats.getDiffFromPrevDay());
    }
}