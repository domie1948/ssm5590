package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZaixianxiadanDao;
import com.entity.ZaixianxiadanEntity;
import com.service.ZaixianxiadanService;
import com.entity.vo.ZaixianxiadanVO;
import com.entity.view.ZaixianxiadanView;

@Service("zaixianxiadanService")
public class ZaixianxiadanServiceImpl extends ServiceImpl<ZaixianxiadanDao, ZaixianxiadanEntity> implements ZaixianxiadanService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZaixianxiadanEntity> page = this.selectPage(
                new Query<ZaixianxiadanEntity>(params).getPage(),
                new EntityWrapper<ZaixianxiadanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZaixianxiadanEntity> wrapper) {
		  Page<ZaixianxiadanView> page =new Query<ZaixianxiadanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZaixianxiadanVO> selectListVO(Wrapper<ZaixianxiadanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZaixianxiadanVO selectVO(Wrapper<ZaixianxiadanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZaixianxiadanView> selectListView(Wrapper<ZaixianxiadanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZaixianxiadanView selectView(Wrapper<ZaixianxiadanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
