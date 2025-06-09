package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyuankuangjieshaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyuankuangjieshaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyuankuangjieshaoView;


/**
 * 园况介绍评论表
 *
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
public interface DiscussyuankuangjieshaoService extends IService<DiscussyuankuangjieshaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyuankuangjieshaoVO> selectListVO(Wrapper<DiscussyuankuangjieshaoEntity> wrapper);
   	
   	DiscussyuankuangjieshaoVO selectVO(@Param("ew") Wrapper<DiscussyuankuangjieshaoEntity> wrapper);
   	
   	List<DiscussyuankuangjieshaoView> selectListView(Wrapper<DiscussyuankuangjieshaoEntity> wrapper);
   	
   	DiscussyuankuangjieshaoView selectView(@Param("ew") Wrapper<DiscussyuankuangjieshaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyuankuangjieshaoEntity> wrapper);
   	
}

