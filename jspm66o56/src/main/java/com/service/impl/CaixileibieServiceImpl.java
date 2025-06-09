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


import com.dao.CaixileibieDao;
import com.entity.CaixileibieEntity;
import com.service.CaixileibieService;
import com.entity.vo.CaixileibieVO;
import com.entity.view.CaixileibieView;

@Service("caixileibieService")
public class CaixileibieServiceImpl extends ServiceImpl<CaixileibieDao, CaixileibieEntity> implements CaixileibieService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CaixileibieEntity> page = this.selectPage(
                new Query<CaixileibieEntity>(params).getPage(),
                new EntityWrapper<CaixileibieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CaixileibieEntity> wrapper) {
		  Page<CaixileibieView> page =new Query<CaixileibieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CaixileibieVO> selectListVO(Wrapper<CaixileibieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CaixileibieVO selectVO(Wrapper<CaixileibieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CaixileibieView> selectListView(Wrapper<CaixileibieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CaixileibieView selectView(Wrapper<CaixileibieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
