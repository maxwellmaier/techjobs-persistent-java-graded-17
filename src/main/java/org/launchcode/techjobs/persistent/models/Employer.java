package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "Location is required")
    @Size(min = 2, max = 100, message = "Location must be between 2 and 100 characters")
    private String location;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    @JoinColumn(name = "employer_id")
    private List<Job> jobs = new ArrayList<>();

    public Employer() {
    }

    public @NotBlank(message = "Location is required") @Size(min = 2, max = 100, message = "Location must be between 2 and 100 characters") String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank(message = "Location is required") @Size(min = 2, max = 100, message = "Location must be between 2 and 100 characters") String location) {
        this.location = location;
    }
}
