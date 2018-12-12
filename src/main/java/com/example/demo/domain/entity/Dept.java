package com.example.demo.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name="dept")
public class Dept implements Serializable {

    @Id
    private Integer deptNo;

    @Column
    private String deptName;

    @Column
    private String deptLoc;

}
