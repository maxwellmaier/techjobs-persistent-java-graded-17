package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Job extends AbstractEntity {



    @ManyToOne

    @NotNull(message = "Employer is required")
    private Employer employer;
    private String skills;


    public Job() {
    }

    public Job(Employer employer, String skills) {
        this.employer = employer;
        this.skills = skills;
    }

    public @NotNull(message = "Employer is required") Employer getEmployer() {
        return employer;
    }

    public void setEmployer(@NotNull(message = "Employer is required") Employer employer) {
        this.employer = employer;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
