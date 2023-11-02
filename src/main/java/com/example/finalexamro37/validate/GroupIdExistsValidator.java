package com.example.finalexamro37.validate;

import com.example.finalexamro37.repository.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GroupIdExistsValidator implements ConstraintValidator<GroupIdExists, Integer> {
    @Autowired
    private IGroupRepository groupRepository;
    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext context) {
        return groupRepository.existsById(id);
    }
}
