package com.uptime.uptime_monitoring_alerting_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uptime.uptime_monitoring_alerting_system.model.UptimeStatus;
import com.uptime.uptime_monitoring_alerting_system.service.UptimeService;

@RestController
public class UptimeController {

    @Autowired
    private UptimeService uptimeService;

    @GetMapping("/uptime")
    public UptimeStatus[] checkUptime() {
        return uptimeService.checkUptime();
    }
}
