package com.entity.view;

import com.entity.ZaixianxiadanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 在线下单
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-02 12:41:47
 */
@TableName("zaixianxiadan")
public class ZaixianxiadanView  extends ZaixianxiadanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZaixianxiadanView(){
	}
 
 	public ZaixianxiadanView(ZaixianxiadanEntity zaixianxiadanEntity){
 	try {
			BeanUtils.copyProperties(this, zaixianxiadanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
