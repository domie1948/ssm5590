package com.dao;

import com.entity.XiaoyuanmeishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiaoyuanmeishiVO;
import com.entity.view.XiaoyuanmeishiView;


/**
 * 校园美食
 * 
 * @author 
 * @email 
 * @date 2021-03-02 12:41:47
 */
public interface XiaoyuanmeishiDao extends BaseMapper<XiaoyuanmeishiEntity> {
	
	List<XiaoyuanmeishiVO> selectListVO(@Param("ew") Wrapper<XiaoyuanmeishiEntity> wrapper);
	
	XiaoyuanmeishiVO selectVO(@Param("ew") Wrapper<XiaoyuanmeishiEntity> wrapper);
	
	List<XiaoyuanmeishiView> selectListView(@Param("ew") Wrapper<XiaoyuanmeishiEntity> wrapper);

	List<XiaoyuanmeishiView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoyuanmeishiEntity> wrapper);
	
	XiaoyuanmeishiView selectView(@Param("ew") Wrapper<XiaoyuanmeishiEntity> wrapper);
	
}
