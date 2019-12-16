package com.fengf.bms.service;

import com.fengf.bms.pojo.Articlecomment;
import com.fengf.bms.pojo.CommentQueryVo;
import com.fengf.common.utils.Page;

public interface CommentService {
    Page<Articlecomment> selectAllPage(CommentQueryVo vo);

    boolean deleteCommentByID(String single);
}
