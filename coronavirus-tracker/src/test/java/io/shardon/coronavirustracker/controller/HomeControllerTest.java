package io.shardon.coronavirustracker.controller;

import io.shardon.coronavirustracker.models.LocationStats;
import io.shardon.coronavirustracker.services.CoronaVirusDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoronaVirusDataService coronaVirusDataService;

    @Test
    public void testHome() throws Exception {
        List<LocationStats> allStats = new ArrayList<>();
        LocationStats locationStats = new LocationStats();
        locationStats.setState("India");
        locationStats.setCountry("India");
        locationStats.setLatestTotalCases(100);
        locationStats.setDiffFromPrevDay(10);
        allStats.add(locationStats);

        given(coronaVirusDataService.getAllStats()).willReturn(allStats);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("locationStats", allStats))
                .andExpect(model().attribute("totalReportedCases", 100))
                .andExpect(model().attribute("totalNewCases", 10));
    }
}