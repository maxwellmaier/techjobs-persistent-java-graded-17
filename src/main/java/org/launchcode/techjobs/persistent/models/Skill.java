package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

    @NotBlank(message = "Description must not be blank.")
    @Size(min= 3, max = 200, message = "Must be between 3 and 200 characters.")
    public String description;

    public Skill() {
    }

    public Skill(String description) {
        this.description = description;
    }

    public @NotBlank(message = "Description must not be blank.") @Size(min = 3, max = 200, message = "Must be between 3 and 200 characters.") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Description must not be blank.") @Size(min = 3, max = 200, message = "Must be between 3 and 200 characters.") String description) {
        this.description = description;
    }
}
