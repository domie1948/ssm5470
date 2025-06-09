package com.dao;

import com.entity.DiscussyuankuangjieshaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyuankuangjieshaoVO;
import com.entity.view.DiscussyuankuangjieshaoView;


/**
 * 园况介绍评论表
 * 
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
public interface DiscussyuankuangjieshaoDao extends BaseMapper<DiscussyuankuangjieshaoEntity> {
	
	List<DiscussyuankuangjieshaoVO> selectListVO(@Param("ew") Wrapper<DiscussyuankuangjieshaoEntity> wrapper);
	
	DiscussyuankuangjieshaoVO selectVO(@Param("ew") Wrapper<DiscussyuankuangjieshaoEntity> wrapper);
	
	List<DiscussyuankuangjieshaoView> selectListView(@Param("ew") Wrapper<DiscussyuankuangjieshaoEntity> wrapper);

	List<DiscussyuankuangjieshaoView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyuankuangjieshaoEntity> wrapper);
	
	DiscussyuankuangjieshaoView selectView(@Param("ew") Wrapper<DiscussyuankuangjieshaoEntity> wrapper);
	
}
