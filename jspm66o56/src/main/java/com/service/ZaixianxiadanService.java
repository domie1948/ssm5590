package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZaixianxiadanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZaixianxiadanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZaixianxiadanView;


/**
 * 在线下单
 *
 * @author 
 * @email 
 * @date 2021-03-02 12:41:47
 */
public interface ZaixianxiadanService extends IService<ZaixianxiadanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZaixianxiadanVO> selectListVO(Wrapper<ZaixianxiadanEntity> wrapper);
   	
   	ZaixianxiadanVO selectVO(@Param("ew") Wrapper<ZaixianxiadanEntity> wrapper);
   	
   	List<ZaixianxiadanView> selectListView(Wrapper<ZaixianxiadanEntity> wrapper);
   	
   	ZaixianxiadanView selectView(@Param("ew") Wrapper<ZaixianxiadanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZaixianxiadanEntity> wrapper);
   	
}

