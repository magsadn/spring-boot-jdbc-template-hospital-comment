package com.magsad.springboothospitalapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long id;
    private String author;
    private String comment;
    private String email;
    private Long hospitalId;
    private Integer isPublished;
}
