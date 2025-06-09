package com.dao;

import com.entity.YuankuangjieshaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuankuangjieshaoVO;
import com.entity.view.YuankuangjieshaoView;


/**
 * 园况介绍
 * 
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
public interface YuankuangjieshaoDao extends BaseMapper<YuankuangjieshaoEntity> {
	
	List<YuankuangjieshaoVO> selectListVO(@Param("ew") Wrapper<YuankuangjieshaoEntity> wrapper);
	
	YuankuangjieshaoVO selectVO(@Param("ew") Wrapper<YuankuangjieshaoEntity> wrapper);
	
	List<YuankuangjieshaoView> selectListView(@Param("ew") Wrapper<YuankuangjieshaoEntity> wrapper);

	List<YuankuangjieshaoView> selectListView(Pagination page,@Param("ew") Wrapper<YuankuangjieshaoEntity> wrapper);
	
	YuankuangjieshaoView selectView(@Param("ew") Wrapper<YuankuangjieshaoEntity> wrapper);
	
}
