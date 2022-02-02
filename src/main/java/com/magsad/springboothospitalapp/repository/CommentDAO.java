package com.magsad.springboothospitalapp.repository;

import com.magsad.springboothospitalapp.model.Comment;
import com.magsad.springboothospitalapp.model.Hospital;

import java.util.List;

public interface CommentDAO {
    Comment getCommentById(Long id);
    List<Comment> getAllComments();
    boolean deleteComment(Comment comment);
    boolean deleteComment(Long id);
    boolean updateComment(Comment comment);
    boolean createComment(Comment comment);
    List<Comment> getCommentsByHospital(Hospital hospital);
}
