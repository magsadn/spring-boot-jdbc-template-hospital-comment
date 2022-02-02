package com.magsad.springboothospitalapp.repository;

import com.magsad.springboothospitalapp.mapper.CommentMapper;
import com.magsad.springboothospitalapp.model.Comment;
import com.magsad.springboothospitalapp.model.Hospital;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository implements CommentDAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Comment getCommentById(Long id) {
        return jdbcTemplate.queryForObject(SQLConstants.SQL_FIND_COMMENT,new Object[]{id},new CommentMapper());
    }

    @Override
    public List<Comment> getAllComments() {
        return jdbcTemplate.query(SQLConstants.SQL_FIND_ALL_COMMENTS,new CommentMapper());
    }

    @Override
    public boolean createComment(Comment comment) {
        return jdbcTemplate.update(SQLConstants.SQL_INSERT_COMMENT,new Object[]{
                comment.getId(),
                comment.getAuthor(),
                comment.getComment(),
                comment.getEmail(),
                comment.getHospitalId(),
                comment.getIsPublished()
        })>0?true:false;
    }

    @Override
    public boolean updateComment(Comment comment) {
        return jdbcTemplate.update(SQLConstants.SQL_UPDATE_COMMENT,new Object[]{
                comment.getAuthor(),
                comment.getComment(),
                comment.getEmail(),
                comment.getHospitalId(),
                comment.getIsPublished()
        })>0?true:false;
    }

    @Override
    public boolean deleteComment(Comment comment) {
        return jdbcTemplate.update(SQLConstants.SQL_DELETE_COMMENT,new Object[]{comment.getId()})>0?true:false;
    }

    @Override
    public boolean deleteComment(Long id) {
        return jdbcTemplate.update(SQLConstants.SQL_DELETE_COMMENT,new Object[]{id})>0?true:false;
    }

    @Override
    public List<Comment> getCommentsByHospital(Hospital hospital) {
        return jdbcTemplate.query(SQLConstants.SQL_FIND_COMMENTS_BY_HOSPITAL, new Object[]{hospital.getId()},new CommentMapper());
    }
}
