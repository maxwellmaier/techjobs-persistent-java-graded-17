package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "Location is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String location;


    public @NotBlank(message = "Location is required") @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank(message = "Location is required") @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") String location) {
        this.location = location;
    }

    public Employer() {
    }

    public Employer(String location) {
        this.location = location;
    }
    @OneToMany(mappedBy = "employer")
    @JoinColumn(name = "employer_id")
    List<Job> jobs = new ArrayList<>();

    @Override
    public String toString() {
        return "Employer{" +
                "location='" + location + '\'' +
                '}';
    }
}
