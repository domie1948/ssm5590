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


import com.dao.DiscussxiaoyuanmeishiDao;
import com.entity.DiscussxiaoyuanmeishiEntity;
import com.service.DiscussxiaoyuanmeishiService;
import com.entity.vo.DiscussxiaoyuanmeishiVO;
import com.entity.view.DiscussxiaoyuanmeishiView;

@Service("discussxiaoyuanmeishiService")
public class DiscussxiaoyuanmeishiServiceImpl extends ServiceImpl<DiscussxiaoyuanmeishiDao, DiscussxiaoyuanmeishiEntity> implements DiscussxiaoyuanmeishiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxiaoyuanmeishiEntity> page = this.selectPage(
                new Query<DiscussxiaoyuanmeishiEntity>(params).getPage(),
                new EntityWrapper<DiscussxiaoyuanmeishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxiaoyuanmeishiEntity> wrapper) {
		  Page<DiscussxiaoyuanmeishiView> page =new Query<DiscussxiaoyuanmeishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussxiaoyuanmeishiVO> selectListVO(Wrapper<DiscussxiaoyuanmeishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussxiaoyuanmeishiVO selectVO(Wrapper<DiscussxiaoyuanmeishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussxiaoyuanmeishiView> selectListView(Wrapper<DiscussxiaoyuanmeishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxiaoyuanmeishiView selectView(Wrapper<DiscussxiaoyuanmeishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
