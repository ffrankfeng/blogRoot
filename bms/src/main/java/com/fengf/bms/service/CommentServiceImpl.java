package com.fengf.bms.service;

import com.fengf.bms.mapper.ArticlecommentMapper;
import com.fengf.bms.pojo.Admin;
import com.fengf.bms.pojo.Articlecomment;
import com.fengf.bms.pojo.CommentQueryVo;
import com.fengf.common.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ArticlecommentMapper articlecommentMapper;
    @Autowired
    private ArticlecommentMapper commentMapper;
    @Override
    public Page<Articlecomment> selectAllPage(CommentQueryVo vo) {
        Page<Articlecomment> page=new Page<Articlecomment>();
        //每页数
        page.setSize(10);
        vo.setSize(10);

        if(vo!=null ){
            //判断当前页
            if(vo.getPage()!=null){
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage()-1)*vo.getSize());
            }
            //总条数
            page.setTotal(articlecommentMapper.commentCountByQueryVo(vo));
            page.setRows(articlecommentMapper.selectCommentListByQueryVo(vo));
        }
        return page;
    }

    @Override
    public boolean deleteCommentByID(String single) {
        int i = commentMapper.deleteByPrimaryKey(Integer.parseInt(single));
        if (i> 0)
            return true;
        return false;
    }
}
