package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Transactional
    public void getEmployeesWithSkill(int skillId) throws Exception{
        System.out.println("Employees with skills");
        Skill skill = skillRepository.findById(skillId).orElseThrow(()->new Exception("Invalid skill Id"));
        List<Employee> employees = skill.getEmployees();
        employees.forEach(System.out::println);
    }
}
