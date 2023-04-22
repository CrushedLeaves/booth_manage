package com.zjp.controller;


import com.zjp.entity.Comment;
import com.zjp.entity.CommentUser;
import com.zjp.service.impl.CommentServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjp
 * @since 2023-04-12
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentServiceImpl commentService;

    @PostMapping("/setComment")
    public String setComment(@RequestBody() Map<String,String> map){
        System.out.println(map);
        Comment comment = new Comment();
        comment.setGoodId(Integer.parseInt(map.get("goodId")));
        comment.setOpenid(map.get("openid"));
        comment.setSpeaktime(map.get("time"));
        comment.setSentence(map.get("sentence"));
        commentService.setComment(comment);
        return "保存成功";
    }
    @GetMapping("/getComment")
    public List<CommentUser> getComment(@RequestParam("goodId")int id){
        return commentService.selectComments(id);
    }

}
