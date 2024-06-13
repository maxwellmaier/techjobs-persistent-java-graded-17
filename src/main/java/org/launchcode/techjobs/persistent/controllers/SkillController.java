package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "All Skills");
        model.addAttribute("employers", skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "skills/list";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                    Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Skill");
            model.addAttribute(new Skill());

        }

        skillRepository.save(newSkill);
        return "redirect:/skills";
    }


    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {

        Optional<Skill> result = skillRepository.findById(skillId);
        if (result.isEmpty()) {
            model.addAttribute("title", "invalid Skill ID: " + skillId);


        } else {
            Skill skill = result.get();
            model.addAttribute("title", skill.getName() + "Description");
            model.addAttribute("skill", skill);

        }
        return "employers/view";
    }
}
