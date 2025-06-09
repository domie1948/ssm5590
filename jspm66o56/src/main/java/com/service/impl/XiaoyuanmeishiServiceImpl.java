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


import com.dao.XiaoyuanmeishiDao;
import com.entity.XiaoyuanmeishiEntity;
import com.service.XiaoyuanmeishiService;
import com.entity.vo.XiaoyuanmeishiVO;
import com.entity.view.XiaoyuanmeishiView;

@Service("xiaoyuanmeishiService")
public class XiaoyuanmeishiServiceImpl extends ServiceImpl<XiaoyuanmeishiDao, XiaoyuanmeishiEntity> implements XiaoyuanmeishiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoyuanmeishiEntity> page = this.selectPage(
                new Query<XiaoyuanmeishiEntity>(params).getPage(),
                new EntityWrapper<XiaoyuanmeishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoyuanmeishiEntity> wrapper) {
		  Page<XiaoyuanmeishiView> page =new Query<XiaoyuanmeishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiaoyuanmeishiVO> selectListVO(Wrapper<XiaoyuanmeishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiaoyuanmeishiVO selectVO(Wrapper<XiaoyuanmeishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiaoyuanmeishiView> selectListView(Wrapper<XiaoyuanmeishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoyuanmeishiView selectView(Wrapper<XiaoyuanmeishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
