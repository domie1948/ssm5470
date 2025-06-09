package com.dao;

import com.entity.DiscussxuexiaogonggaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussxuexiaogonggaoVO;
import com.entity.view.DiscussxuexiaogonggaoView;


/**
 * 学校公告评论表
 * 
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
public interface DiscussxuexiaogonggaoDao extends BaseMapper<DiscussxuexiaogonggaoEntity> {
	
	List<DiscussxuexiaogonggaoVO> selectListVO(@Param("ew") Wrapper<DiscussxuexiaogonggaoEntity> wrapper);
	
	DiscussxuexiaogonggaoVO selectVO(@Param("ew") Wrapper<DiscussxuexiaogonggaoEntity> wrapper);
	
	List<DiscussxuexiaogonggaoView> selectListView(@Param("ew") Wrapper<DiscussxuexiaogonggaoEntity> wrapper);

	List<DiscussxuexiaogonggaoView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxuexiaogonggaoEntity> wrapper);
	
	DiscussxuexiaogonggaoView selectView(@Param("ew") Wrapper<DiscussxuexiaogonggaoEntity> wrapper);
	
}
