package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

import java.util.ArrayList;

@Entity
public class Skill extends AbstractEntity {

        @NotBlank(message = "Description is required")
        @Size(max = 500, message = "Description must be less than 500 characters")
        private String description;

        @ManyToMany(mappedBy = "skills")
        private final List<Job> jobs = new ArrayList<>();

        // No-argument constructor
        public Skill() {}

        // Getter method for description
        public String getDescription() {
            return description;
        }

        // Setter method for description
        public void setDescription(String description) {
            this.description = description;
        }

        public List<Job> getJobs() {
                return jobs;
        }
}
