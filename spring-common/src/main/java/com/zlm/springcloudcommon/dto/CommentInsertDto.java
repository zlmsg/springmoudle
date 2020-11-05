package com.zlm.springcloudcommon.dto;

import lombok.Data;

@Data
public class CommentInsertDto {
    private int uid;
    private int cid;
    private String content;
}
