package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XuexiaogonggaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XuexiaogonggaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XuexiaogonggaoView;


/**
 * 学校公告
 *
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
public interface XuexiaogonggaoService extends IService<XuexiaogonggaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XuexiaogonggaoVO> selectListVO(Wrapper<XuexiaogonggaoEntity> wrapper);
   	
   	XuexiaogonggaoVO selectVO(@Param("ew") Wrapper<XuexiaogonggaoEntity> wrapper);
   	
   	List<XuexiaogonggaoView> selectListView(Wrapper<XuexiaogonggaoEntity> wrapper);
   	
   	XuexiaogonggaoView selectView(@Param("ew") Wrapper<XuexiaogonggaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XuexiaogonggaoEntity> wrapper);
   	
}

