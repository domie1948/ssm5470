package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiazhanggoutongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiazhanggoutongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiazhanggoutongView;


/**
 * 家长沟通
 *
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
public interface JiazhanggoutongService extends IService<JiazhanggoutongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiazhanggoutongVO> selectListVO(Wrapper<JiazhanggoutongEntity> wrapper);
   	
   	JiazhanggoutongVO selectVO(@Param("ew") Wrapper<JiazhanggoutongEntity> wrapper);
   	
   	List<JiazhanggoutongView> selectListView(Wrapper<JiazhanggoutongEntity> wrapper);
   	
   	JiazhanggoutongView selectView(@Param("ew") Wrapper<JiazhanggoutongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiazhanggoutongEntity> wrapper);
   	
}

