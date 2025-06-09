package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussxiaoyuanmeishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussxiaoyuanmeishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussxiaoyuanmeishiView;


/**
 * 校园美食评论表
 *
 * @author 
 * @email 
 * @date 2021-03-02 12:41:47
 */
public interface DiscussxiaoyuanmeishiService extends IService<DiscussxiaoyuanmeishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxiaoyuanmeishiVO> selectListVO(Wrapper<DiscussxiaoyuanmeishiEntity> wrapper);
   	
   	DiscussxiaoyuanmeishiVO selectVO(@Param("ew") Wrapper<DiscussxiaoyuanmeishiEntity> wrapper);
   	
   	List<DiscussxiaoyuanmeishiView> selectListView(Wrapper<DiscussxiaoyuanmeishiEntity> wrapper);
   	
   	DiscussxiaoyuanmeishiView selectView(@Param("ew") Wrapper<DiscussxiaoyuanmeishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxiaoyuanmeishiEntity> wrapper);
   	
}

