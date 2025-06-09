package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GoutonghuifuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GoutonghuifuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GoutonghuifuView;


/**
 * 沟通回复
 *
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
public interface GoutonghuifuService extends IService<GoutonghuifuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoutonghuifuVO> selectListVO(Wrapper<GoutonghuifuEntity> wrapper);
   	
   	GoutonghuifuVO selectVO(@Param("ew") Wrapper<GoutonghuifuEntity> wrapper);
   	
   	List<GoutonghuifuView> selectListView(Wrapper<GoutonghuifuEntity> wrapper);
   	
   	GoutonghuifuView selectView(@Param("ew") Wrapper<GoutonghuifuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GoutonghuifuEntity> wrapper);
   	
}

