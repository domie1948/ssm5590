package com.dao;

import com.entity.CaixileibieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CaixileibieVO;
import com.entity.view.CaixileibieView;


/**
 * 菜系类别
 * 
 * @author 
 * @email 
 * @date 2021-03-02 12:41:46
 */
public interface CaixileibieDao extends BaseMapper<CaixileibieEntity> {
	
	List<CaixileibieVO> selectListVO(@Param("ew") Wrapper<CaixileibieEntity> wrapper);
	
	CaixileibieVO selectVO(@Param("ew") Wrapper<CaixileibieEntity> wrapper);
	
	List<CaixileibieView> selectListView(@Param("ew") Wrapper<CaixileibieEntity> wrapper);

	List<CaixileibieView> selectListView(Pagination page,@Param("ew") Wrapper<CaixileibieEntity> wrapper);
	
	CaixileibieView selectView(@Param("ew") Wrapper<CaixileibieEntity> wrapper);
	
}
