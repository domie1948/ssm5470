package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuankuangjieshaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuankuangjieshaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuankuangjieshaoView;


/**
 * 园况介绍
 *
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
public interface YuankuangjieshaoService extends IService<YuankuangjieshaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuankuangjieshaoVO> selectListVO(Wrapper<YuankuangjieshaoEntity> wrapper);
   	
   	YuankuangjieshaoVO selectVO(@Param("ew") Wrapper<YuankuangjieshaoEntity> wrapper);
   	
   	List<YuankuangjieshaoView> selectListView(Wrapper<YuankuangjieshaoEntity> wrapper);
   	
   	YuankuangjieshaoView selectView(@Param("ew") Wrapper<YuankuangjieshaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuankuangjieshaoEntity> wrapper);
   	
}

