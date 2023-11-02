package com.example.finalexamro37.service.Group;

import com.example.finalexamro37.entity.Group;
import com.example.finalexamro37.form.Group.CreatingGroupForm;
import com.example.finalexamro37.form.Group.GroupFilterForm;
import com.example.finalexamro37.form.Group.UpdatingGroupForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGroupService {
    Page<Group> getAllGroup (Pageable pageable, GroupFilterForm form);

    Group getGroupById(int id);

    void createGroup(CreatingGroupForm form);
    void updateGroup(UpdatingGroupForm form);

    void deleteGroupById(int id);
}
