package com.magsad.springboothospitalapp.service;

import com.magsad.springboothospitalapp.model.Comment;
import com.magsad.springboothospitalapp.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    private final Logger LOGGER = Logger.getLogger(Comment.class.getName());
    public List<Comment> findAll(){
        LOGGER.info("Started... findAll");
        List<Comment> comments = commentRepository.getAllComments();
        LOGGER.info(String.format("hospitals : %s",comments));
        return comments;
    }

    public Comment findById(Long id) {
        Comment comment = commentRepository.getCommentById(id);
        return comment;
    }

    public Comment save(Comment comment) {
        commentRepository.createComment(comment);
        return comment;
    }

    public Comment update(Comment comment) {
        commentRepository.updateComment(comment);
        return comment;
    }

    public Comment delete(Comment comment) {
        commentRepository.deleteComment(comment);
        return comment;
    }

    public Comment delete(Long id) {
        Comment comment = commentRepository.getCommentById(id);
        commentRepository.deleteComment(id);
        return comment;
    }
}
