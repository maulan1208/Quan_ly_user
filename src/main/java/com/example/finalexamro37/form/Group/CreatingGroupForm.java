package com.example.finalexamro37.form.Group;

import com.example.finalexamro37.validate.GroupNameNotExists;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreatingGroupForm {

    @Length(max = 50, message = "Group.createGroup.form.name.Length")
    @NotBlank(message = "Group.createGroup.form.name.NotBlank")
    @GroupNameNotExists
    private String groupName;

    private String creator;


}
