package com.tutrit.controller;

import com.tutrit.bean.Engineer;
import com.tutrit.service.EngineerService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EngineerController {

    private final EngineerService engineerService;

    public EngineerController(final EngineerService engineerService) {
        this.engineerService = engineerService;
    }

    @GetMapping("/engineers/{id}")
    public Engineer getById(@PathVariable String id) {
        return engineerService.findById(id);
    }

    @PostMapping("/engineers")
    public Engineer post(@RequestBody Engineer engineer) {
        return engineerService.save(engineer);
    }
}
