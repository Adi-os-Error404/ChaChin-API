package com.adityapdev.ChaChing_api.controller;

import com.adityapdev.ChaChing_api.dto.coin.AddCoinDto;
import com.adityapdev.ChaChing_api.dto.coin.CoinDetailDto;
import com.adityapdev.ChaChing_api.dto.comment.AddCommentDto;
import com.adityapdev.ChaChing_api.dto.comment.CommentDetailDto;
import com.adityapdev.ChaChing_api.dto.comment.EditCommentDto;
import com.adityapdev.ChaChing_api.service.interfaces.ICoinService;
import com.adityapdev.ChaChing_api.service.interfaces.ICommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private ICommentService commentService;

    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{coinId}")
    public ResponseEntity<CommentDetailDto> addComment(@PathVariable String coinId, @RequestBody AddCommentDto addCommentDto) {
        CommentDetailDto createdComment = commentService.addComment(coinId, addCommentDto);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @PutMapping("/{coinId}")
    public ResponseEntity<CommentDetailDto> updateComment(@PathVariable String coinId, @RequestBody EditCommentDto editCommentDto) {
        CommentDetailDto updatedComment = commentService.updateComment(coinId, editCommentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

}
