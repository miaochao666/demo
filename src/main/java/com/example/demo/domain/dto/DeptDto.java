package com.example.demo.domain.dto;


import lombok.Data;

/**
 * @Data自动生成set、get、有参、无参、toString()方法
 */
@Data
public class DeptDto {
    private int dept_no;

    private String dept_name;

    private String dept_loc;

}
