package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiaoyuanmeishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiaoyuanmeishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoyuanmeishiView;


/**
 * 校园美食
 *
 * @author 
 * @email 
 * @date 2021-03-02 12:41:47
 */
public interface XiaoyuanmeishiService extends IService<XiaoyuanmeishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoyuanmeishiVO> selectListVO(Wrapper<XiaoyuanmeishiEntity> wrapper);
   	
   	XiaoyuanmeishiVO selectVO(@Param("ew") Wrapper<XiaoyuanmeishiEntity> wrapper);
   	
   	List<XiaoyuanmeishiView> selectListView(Wrapper<XiaoyuanmeishiEntity> wrapper);
   	
   	XiaoyuanmeishiView selectView(@Param("ew") Wrapper<XiaoyuanmeishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoyuanmeishiEntity> wrapper);
   	
}

