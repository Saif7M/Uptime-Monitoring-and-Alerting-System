package com.uptime.uptime_monitoring_alerting_system.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.uptime.uptime_monitoring_alerting_system.model.UptimeStatus;

@Service
public class UptimeService {

    private static final String[] URLs_TO_MONITOR = {"https://example1.com", "https://example2.com"};

    public UptimeStatus[] checkUptime() {
        UptimeStatus[] statuses = new UptimeStatus[URLs_TO_MONITOR.length];
        RestTemplate restTemplate = new RestTemplate();

        for (int i = 0; i < URLs_TO_MONITOR.length; i++) {
            UptimeStatus status = new UptimeStatus();
            String url = URLs_TO_MONITOR[i];
            status.setUrl(url);

            try {
                restTemplate.getForObject(url, String.class);
                status.setUp(true);
                status.setMessage("Service is up.");
            } catch (RestClientException e) {
                status.setUp(false);
                status.setMessage("Service is down: " + e.getMessage());
            }

            statuses[i] = status;
        }

        return statuses;
    }
}
