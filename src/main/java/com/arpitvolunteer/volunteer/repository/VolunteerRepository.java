package com.arpitvolunteer.volunteer.repository;

import com.arpitvolunteer.volunteer.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
    List<Volunteer> findByAvailableTrue();
}