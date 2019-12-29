package com.akenori.web.mock;

import com.akenori.web.mock.model.Archive;
import com.akenori.web.mock.model.SystemInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ServerController {

    private int time = 1;

    @RequestMapping("/info")
    public SystemInfo getSystemInfo() {
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setBattery_level(100);
        systemInfo.setTotal_space(4100);
        systemInfo.setFilled_space(1100);
        systemInfo.setRecording(true);
        systemInfo.setRecording_status(time++);
        systemInfo.setSn("777");
        systemInfo.setStorage(true);
        systemInfo.setStorage_wp(true);
        systemInfo.setVersion("1.1.136");
        return systemInfo;
    }

    @RequestMapping("/archive")
    public List<Archive> getArchives() {
        return Collections.emptyList();
    }

}
