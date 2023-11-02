package com.example.finalexamro37.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "`Group`")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "group_name",length = 50, nullable = false, unique = true)
    private String groupName;

    @Column(name = "member", nullable = false)
    private int member;

    @Column(name = "creator")
    private String creator;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;

    @OneToMany(mappedBy = "group")
    private List<Account> accounts;

}
