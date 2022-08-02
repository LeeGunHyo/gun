package com.oraclejava.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SignUpForm {

    private  String  userId;
    private  String  password;
    private  String  name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private  int  age;



}

