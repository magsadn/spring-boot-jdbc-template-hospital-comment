package com.magsad.springboothospitalapp.mapper;

import com.magsad.springboothospitalapp.model.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setId(rs.getLong("id"));
        comment.setAuthor(rs.getString("author"));
        comment.setComment(rs.getString("comment"));
        comment.setEmail(rs.getString("email"));
        comment.setHospitalId(rs.getLong("hospital_id"));
        comment.setIsPublished(rs.getInt("is_published"));
        return comment;
    }
}
