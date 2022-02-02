package com.magsad.springboothospitalapp.controller;

import com.magsad.springboothospitalapp.model.Comment;
import com.magsad.springboothospitalapp.model.Hospital;
import com.magsad.springboothospitalapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("comments")
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> getComments(){
        return ResponseEntity.ok(commentService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Comment> getHospitalById(@PathVariable Long id){
        return ResponseEntity.ok(commentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Comment> save(@RequestBody Comment comment){
        return ResponseEntity.ok(commentService.save(comment));
    }

    @PutMapping
    public ResponseEntity<Comment> update(@RequestBody Comment comment){
        return ResponseEntity.ok(commentService.update(comment));
    }

    @DeleteMapping
    public ResponseEntity<Comment> delete(@RequestBody Comment comment){
        return ResponseEntity.ok(commentService.delete(comment));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Comment> deleteCommentById(@PathVariable Long id){
        return ResponseEntity.ok(commentService.delete(id));
    }

    @DeleteMapping("query")
    public ResponseEntity<Comment> deleteCommentByIdQuery(@RequestParam Long id){
        return ResponseEntity.ok(commentService.delete(id));
    }


    @GetMapping("query{commentId}")
    public ResponseEntity<Comment> getCommentByIdQuery2(@RequestParam("commentId") Long id){//(@RequestParam(name = "hospitalId")
        return ResponseEntity.ok(commentService.findById(id));
    }
}
