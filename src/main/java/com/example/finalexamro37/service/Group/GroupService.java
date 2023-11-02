package com.example.finalexamro37.service.Group;

import com.example.finalexamro37.entity.Group;
import com.example.finalexamro37.form.Group.CreatingGroupForm;
import com.example.finalexamro37.form.Group.GroupFilterForm;
import com.example.finalexamro37.form.Group.UpdatingGroupForm;
import com.example.finalexamro37.repository.IGroupRepository;
import com.example.finalexamro37.specification.GroupSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class GroupService implements IGroupService {
    @Autowired
    private IGroupRepository groupRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Page<Group> getAllGroup(Pageable pageable, GroupFilterForm form) {
        Specification<Group> where = GroupSpecification.buildWhere(form);
        return groupRepository.findAll(where, pageable);
    }

    @Override
    public Group getGroupById(int id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public void createGroup(CreatingGroupForm form) {
        Group group = modelMapper.map(form, Group.class);
        groupRepository.save(group);
    }

    @Override
    public void updateGroup(UpdatingGroupForm form) {
        Group group = modelMapper.map(form, Group.class);
        groupRepository.save(group);
    }

    @Override
    public void deleteGroupById(int id) {
        groupRepository.deleteById(id);
    }
}
