package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussxuexiaogonggaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussxuexiaogonggaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussxuexiaogonggaoView;


/**
 * 学校公告评论表
 *
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
public interface DiscussxuexiaogonggaoService extends IService<DiscussxuexiaogonggaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxuexiaogonggaoVO> selectListVO(Wrapper<DiscussxuexiaogonggaoEntity> wrapper);
   	
   	DiscussxuexiaogonggaoVO selectVO(@Param("ew") Wrapper<DiscussxuexiaogonggaoEntity> wrapper);
   	
   	List<DiscussxuexiaogonggaoView> selectListView(Wrapper<DiscussxuexiaogonggaoEntity> wrapper);
   	
   	DiscussxuexiaogonggaoView selectView(@Param("ew") Wrapper<DiscussxuexiaogonggaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxuexiaogonggaoEntity> wrapper);
   	
}

