package com.example.finalexamro37.form.Account;

import com.example.finalexamro37.entity.Group;
import com.example.finalexamro37.validate.GroupNameNotExists;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class CreatingAccountForm {
    @Length(max = 50, message = "Group.createGroup.form.name.Length")
    @NotBlank(message = "Group.createGroup.form.name.NotBlank")
    private String username;

    private int groupId;
}
