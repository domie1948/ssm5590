package com.dao;

import com.entity.DiscussxiaoyuanmeishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussxiaoyuanmeishiVO;
import com.entity.view.DiscussxiaoyuanmeishiView;


/**
 * 校园美食评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-02 12:41:47
 */
public interface DiscussxiaoyuanmeishiDao extends BaseMapper<DiscussxiaoyuanmeishiEntity> {
	
	List<DiscussxiaoyuanmeishiVO> selectListVO(@Param("ew") Wrapper<DiscussxiaoyuanmeishiEntity> wrapper);
	
	DiscussxiaoyuanmeishiVO selectVO(@Param("ew") Wrapper<DiscussxiaoyuanmeishiEntity> wrapper);
	
	List<DiscussxiaoyuanmeishiView> selectListView(@Param("ew") Wrapper<DiscussxiaoyuanmeishiEntity> wrapper);

	List<DiscussxiaoyuanmeishiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxiaoyuanmeishiEntity> wrapper);
	
	DiscussxiaoyuanmeishiView selectView(@Param("ew") Wrapper<DiscussxiaoyuanmeishiEntity> wrapper);
	
}
