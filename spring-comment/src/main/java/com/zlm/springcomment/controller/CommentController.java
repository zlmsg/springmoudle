package com.zlm.springcomment.controller;

import com.zlm.springcloudcommon.dto.CommentDeleteDto;
import com.zlm.springcloudcommon.dto.CommentInsertDto;
import com.zlm.springcloudcommon.vo.R;
import com.zlm.springcomment.servcie.intf.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/comment/")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("add")
    //添加评论
    public R insert(CommentInsertDto commentInsertDto){
        return commentService.insert(commentInsertDto);
    }

    @GetMapping("delete")
    //删除评论
    public R delete(CommentDeleteDto deleteDto){
        return commentService.delete(deleteDto);
    }
    //根据文章查询评论
    public R selectByCid(Integer cid){
        return commentService.selectByCid(cid);
    }
    //点赞
    public R likeAdd(Integer id){
        return commentService.likeAdd(id);
    }
    //取消点赞
    public R likeDelete(Integer id){
        return commentService.likeDelete(id);
    }
}
