package com.entity.view;

import com.entity.YuankuangjieshaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 园况介绍
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
@TableName("yuankuangjieshao")
public class YuankuangjieshaoView  extends YuankuangjieshaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YuankuangjieshaoView(){
	}
 
 	public YuankuangjieshaoView(YuankuangjieshaoEntity yuankuangjieshaoEntity){
 	try {
			BeanUtils.copyProperties(this, yuankuangjieshaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
