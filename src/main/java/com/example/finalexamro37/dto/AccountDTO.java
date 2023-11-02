package com.example.finalexamro37.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountDTO {
    private int id;
    private String username;
    private int groupId;
    private String groupName;
}
