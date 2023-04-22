package com.zjp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjp.entity.Comment;
import com.zjp.entity.CommentUser;
import com.zjp.entity.User;
import com.zjp.mapper.CommentMapper;
import com.zjp.mapper.UserMapper;
import com.zjp.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zjp
 * @since 2023-04-12
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Resource
    private CommentMapper commentMapper;

    @Autowired
    private UserServiceImpl userService;
    //保存评论
    public boolean setComment(Comment comment){
        try{
            commentMapper.insert(comment);
            return true;
        }catch (Exception e){
            System.out.println("保存失败");
            return false;
        }

    }
    //查询评论
    public List<CommentUser> selectComments(int id){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("good_id",id);
        List<Comment> comments = commentMapper.selectList(wrapper);
        List<CommentUser> commentUsers = new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
            String openid = comments.get(i).getOpenid();
            User user = userService.getUserInfo(openid);
            CommentUser commentUser = new CommentUser();
            commentUser.setComment(comments.get(i));
            commentUser.setUser(user);
            commentUsers.add(commentUser);
        }
        return commentUsers;
    }

}
