package com.entity.view;

import com.entity.GoutonghuifuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 沟通回复
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
@TableName("goutonghuifu")
public class GoutonghuifuView  extends GoutonghuifuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoutonghuifuView(){
	}
 
 	public GoutonghuifuView(GoutonghuifuEntity goutonghuifuEntity){
 	try {
			BeanUtils.copyProperties(this, goutonghuifuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
