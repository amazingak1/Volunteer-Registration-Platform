package com.arpitvolunteer.volunteer.service;


import com.arpitvolunteer.volunteer.model.Volunteer;
import com.arpitvolunteer.volunteer.repository.VolunteerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {
    private final VolunteerRepository repo;

    public VolunteerService(VolunteerRepository repo) {
        this.repo = repo;
    }

    public List<Volunteer> all()                 { return repo.findAll(); }
    public Volunteer byId(Long id)               { return repo.findById(id).orElseThrow(); }
    public List<Volunteer> available()           { return repo.findByAvailableTrue(); }
    public Volunteer save(Volunteer v)           { return repo.save(v); }
    public Volunteer update(Long id, Volunteer v){
        Volunteer existing = byId(id);
        existing.setName(v.getName());
        existing.setEmail(v.getEmail());
        existing.setAvailable(v.isAvailable());
        return repo.save(existing);
    }
    public void delete(Long id)                  { repo.deleteById(id); }
}