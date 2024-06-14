package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

        @NotBlank(message = "Description is required")
        @Size(max = 500, message = "Description must be less than 500 characters")
        private String description;

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


}
