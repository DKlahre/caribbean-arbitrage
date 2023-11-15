package com.codeinvestigator.multiple_datasources.emp;

import javax.persistence.GeneratedValue;
import lombok.Data;
import javax.persistence.*;
import javax.persistence.GenerationType;

@Data
@Table
@Entity
public class Employees {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private String roomNum;

    @Column
    private String jobTitle;

    @Column
    private boolean checkedIn;


}
