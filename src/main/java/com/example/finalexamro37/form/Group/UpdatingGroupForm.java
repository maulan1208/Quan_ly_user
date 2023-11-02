package com.example.finalexamro37.form.Group;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UpdatingGroupForm {
    private int id;
    private String groupName;
    private int member;
    private String creator;
    private Date createdDate;
}
