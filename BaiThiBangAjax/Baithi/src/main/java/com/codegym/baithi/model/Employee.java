package com.codegym.baithi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Không để trống")
    @Size(min = 2,max = 40,message = "Tên tối thiểu 2 kí tự tối đa 40 kí tự")
    private String name;

    @NotNull(message = "Không để trống")
    private Date dob;

    @NotNull(message = "Không để trống")
    private String gender;

    @NotBlank(message = "Không để trống")
    @Size(min = 10,max = 11)
    @Pattern(regexp ="^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$" )
    private String phone;

    @NotBlank(message = "Không để trống")
    @Size(min = 9,max=9,message = "Số chứng minh gồm 9 số")
    private String cmnd;

    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    @NotBlank(message = "Không để trống")
    private String address;

    @ManyToOne
    private Office office;

}
