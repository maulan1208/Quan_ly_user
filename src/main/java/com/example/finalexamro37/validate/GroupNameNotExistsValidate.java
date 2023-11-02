package com.example.finalexamro37.validate;

import com.example.finalexamro37.repository.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GroupNameNotExistsValidate implements ConstraintValidator<GroupNameNotExists, String> {
    @Autowired
    private IGroupRepository groupRepository;

    @Override
    public boolean isValid(String groupName, ConstraintValidatorContext constraintValidatorContext) {
        return !groupRepository.existsByGroupName(groupName);
    }
}
