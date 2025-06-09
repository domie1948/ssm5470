package com.entity.view;

import com.entity.DiscussxuexiaogonggaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 学校公告评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
@TableName("discussxuexiaogonggao")
public class DiscussxuexiaogonggaoView  extends DiscussxuexiaogonggaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussxuexiaogonggaoView(){
	}
 
 	public DiscussxuexiaogonggaoView(DiscussxuexiaogonggaoEntity discussxuexiaogonggaoEntity){
 	try {
			BeanUtils.copyProperties(this, discussxuexiaogonggaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
