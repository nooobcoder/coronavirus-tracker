package io.shardon.coronavirustracker.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CoronaVirusDataServiceTest {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @Test
    public void fetchVirusData() throws IOException, InterruptedException {
        coronaVirusDataService.fetchVirusData();
        assertEquals(coronaVirusDataService.getAllStats().size(), 285);
    }
}