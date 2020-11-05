package com.zlm.springcomment.dao;

import com.zlm.springcloudcommon.entity.Comment;
import com.zlm.springcloudcommon.vo.R;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
    //添加评论
    @Insert("insert into t_comment (uid,content,ctime,likes,cid) value(#{uid},#{content},#{ctime},#{likes},#{cid})")
    int insert(Comment comment);

    @Delete("delete from t_comment where id = #{id}")
    int delete(Integer id);

    @Select("select * from t_comment where cid = #{cid}")
    @ResultType(Comment.class)
    List<Comment> selectByCid(Integer cid);

    @Update("update t_comment set likes = likes+1")
    int likeAdd(Integer id);

    @Update("update t_comment set likes = likes-1")
    int likeDelete(Integer id);
}
