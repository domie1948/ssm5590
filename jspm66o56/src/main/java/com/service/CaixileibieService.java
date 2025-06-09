package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CaixileibieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CaixileibieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CaixileibieView;


/**
 * 菜系类别
 *
 * @author 
 * @email 
 * @date 2021-03-02 12:41:46
 */
public interface CaixileibieService extends IService<CaixileibieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CaixileibieVO> selectListVO(Wrapper<CaixileibieEntity> wrapper);
   	
   	CaixileibieVO selectVO(@Param("ew") Wrapper<CaixileibieEntity> wrapper);
   	
   	List<CaixileibieView> selectListView(Wrapper<CaixileibieEntity> wrapper);
   	
   	CaixileibieView selectView(@Param("ew") Wrapper<CaixileibieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CaixileibieEntity> wrapper);
   	
}

