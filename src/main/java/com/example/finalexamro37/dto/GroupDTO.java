package com.example.finalexamro37.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GroupDTO {
    private int id;
    private String groupName;
    private int member;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String creator;
    private Date createdDate;
    private List<AccountDTO> accounts;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class AccountDTO {
        private String username;
    }
}
