package com.zlm.springcomment.servcie.impl;

import com.zlm.springcloudcommon.config.CommentConfig;
import com.zlm.springcloudcommon.dto.CommentDeleteDto;
import com.zlm.springcloudcommon.dto.CommentInsertDto;
import com.zlm.springcloudcommon.entity.Comment;
import com.zlm.springcloudcommon.third.RedissonUtil;
import com.zlm.springcloudcommon.vo.R;
import com.zlm.springcomment.dao.CommentDao;
import com.zlm.springcomment.servcie.intf.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public R insert(CommentInsertDto commentInsertDto) {
        if (commentInsertDto != null) {
            if (commentInsertDto.getCid() > 0 && commentInsertDto.getContent() != "" && commentInsertDto.getUid() > 0) {
                Comment comment = new Comment(commentInsertDto.getUid(), commentInsertDto.getCid(), commentInsertDto.getContent(), new Date(), 0);
                if (commentDao.insert(comment) > 0) {
                    return R.ok();
                }
            }
        }
        return R.fail();
    }

    @Override
    public R delete(CommentDeleteDto commentDeleteDto) {
        String key = CommentConfig.COMMENT_CID + commentDeleteDto.getCid();
        if (commentDeleteDto != null) {
            if (commentDeleteDto.getId() > 0) {
                if (commentDao.delete(commentDeleteDto.getId()) > 0) {
                    RedissonUtil.delHash(key, commentDeleteDto.getId() + "");
                    return R.ok();
                }
            }
        }
        return R.fail();
    }

    @Override
    public R selectByCid(Integer cid) {
        String key = CommentConfig.COMMENT_CID + cid;
        if (cid != null) {
            if (cid > 0) {
                if (RedissonUtil.checkKey(key)) {
                    return R.ok(RedissonUtil.getKeys(key));
                } else {
                    List<Comment> comments = commentDao.selectByCid(cid);
                    HashMap<String, Object> map = new HashMap<>();
                    for (Comment comment : comments) {
                        map.put(comment.getId() + "", comment);
                    }
                    RedissonUtil.setHashAll(key, map);
                    return R.ok(comments);
                }
            }
        }
        return R.fail();
    }

    @Override
    public R likeAdd(Integer id) {
        if (id != null) {
            if (id > 0) {
                if (commentDao.likeAdd(id) > 0) {
                    return R.ok();
                }
            }
        }
        return R.fail();
    }

    @Override
    public R likeDelete(Integer id) {
        if (id != null) {
            if (id > 0) {
                if (commentDao.likeDelete(id) > 0) {
                    return R.ok();
                }
            }
        }
        return R.fail();
    }
}
