package com.zlm.springcomment.servcie.intf;

import com.zlm.springcloudcommon.dto.CommentDeleteDto;
import com.zlm.springcloudcommon.dto.CommentInsertDto;
import com.zlm.springcloudcommon.vo.R;


public interface CommentService {

    R insert(CommentInsertDto commentInsertDto);

    R delete(CommentDeleteDto id);

    R selectByCid(Integer cid);

    R likeAdd(Integer id);

    R likeDelete(Integer id);
}
