package com.zlm.springcloudcommon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Comment {
    private int id;
    private int uid;
    private int cid;
    private String content;
    private Date ctime;
    private int likes;

    public Comment(int uid, int cid, String content, Date ctime, int likes) {
        this.uid = uid;
        this.cid = cid;
        this.content = content;
        this.ctime = ctime;
        this.likes = likes;
    }
}
