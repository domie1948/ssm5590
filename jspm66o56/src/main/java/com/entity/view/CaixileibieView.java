package com.entity.view;

import com.entity.CaixileibieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 菜系类别
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-02 12:41:46
 */
@TableName("caixileibie")
public class CaixileibieView  extends CaixileibieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CaixileibieView(){
	}
 
 	public CaixileibieView(CaixileibieEntity caixileibieEntity){
 	try {
			BeanUtils.copyProperties(this, caixileibieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
