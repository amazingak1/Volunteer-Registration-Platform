package com.arpitvolunteer.volunteer.controller;

import com.arpitvolunteer.volunteer.model.Volunteer;
import com.arpitvolunteer.volunteer.service.VolunteerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = {"http://localhost:3000","http://localhost:8080"}) // Add your frontend URL here
public class VolunteerController {

    private final VolunteerService svc;

    public VolunteerController(VolunteerService svc) {
        this.svc = svc;
    }

    @GetMapping("/volunteers")
    public List<Volunteer> list() {
        return svc.all();
    }

    @GetMapping("/volunteer/{id}")
    public Volunteer get(@PathVariable Long id) {
        return svc.byId(id);
    }

    @GetMapping("/volunteers/available")
    public List<Volunteer> available() {
        return svc.available();
    }

    @GetMapping("/")
    public String home() {
        return "Volunteer API is running";
    }



    @PostMapping("/volunteer")
    @ResponseStatus(HttpStatus.CREATED)
    public Volunteer create(@RequestBody Volunteer v) {
        return svc.save(v);
    }

    @PutMapping("/volunteer/{id}")
    public Volunteer update(@PathVariable Long id, @RequestBody Volunteer v) {
        return svc.update(id, v);
    }

    @DeleteMapping("/volunteer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        svc.delete(id);
    }
}