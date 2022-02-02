package com.magsad.springboothospitalapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private List<Comment> commentList;
}
