package com.example.finalexamro37.controller;

import com.example.finalexamro37.dto.GroupDTO;
import com.example.finalexamro37.entity.Group;
import com.example.finalexamro37.form.Group.CreatingGroupForm;
import com.example.finalexamro37.form.Group.GroupFilterForm;
import com.example.finalexamro37.form.Group.UpdatingGroupForm;
import com.example.finalexamro37.service.Group.IGroupService;
import com.example.finalexamro37.validate.GroupIdExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/groups")
@Validated
@CrossOrigin(origins = "http://127.0.0.1:5502/")
public class GroupController {
    @Autowired
    private IGroupService groupService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public Page<GroupDTO> getAllGroup(Pageable pageable, GroupFilterForm form){
//
        Page<Group> groupPage = groupService.getAllGroup(pageable, form);
        List<Group> groupList = groupPage.getContent();
        List<GroupDTO> groupDTOList =
                groupList.stream().map(group -> modelMapper.map(group, GroupDTO.class))
                        .collect(Collectors.toList());
        return new PageImpl<>(groupDTOList, pageable, groupPage.getTotalElements());
    }

    @GetMapping("{id}")
    public GroupDTO getGroupById(@PathVariable int id){
        Group group = groupService.getGroupById(id);
        return modelMapper.map(group, GroupDTO.class);
    }

    @PostMapping()
    public ResponseEntity createGroup(@RequestBody @Valid CreatingGroupForm form) {
        groupService.createGroup(form);
        return new ResponseEntity<>("Tao thanh cong", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public void updateGroup(@PathVariable @GroupIdExists int id, @RequestBody UpdatingGroupForm form){
        form.setId(id);
        groupService.updateGroup(form);
    }

    @DeleteMapping("{id}")
    public void deleteGroup(@PathVariable @GroupIdExists int id){
        groupService.deleteGroupById(id);
    }
}
