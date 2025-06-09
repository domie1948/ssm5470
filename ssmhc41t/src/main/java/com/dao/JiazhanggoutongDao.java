package com.dao;

import com.entity.JiazhanggoutongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiazhanggoutongVO;
import com.entity.view.JiazhanggoutongView;


/**
 * 家长沟通
 * 
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
public interface JiazhanggoutongDao extends BaseMapper<JiazhanggoutongEntity> {
	
	List<JiazhanggoutongVO> selectListVO(@Param("ew") Wrapper<JiazhanggoutongEntity> wrapper);
	
	JiazhanggoutongVO selectVO(@Param("ew") Wrapper<JiazhanggoutongEntity> wrapper);
	
	List<JiazhanggoutongView> selectListView(@Param("ew") Wrapper<JiazhanggoutongEntity> wrapper);

	List<JiazhanggoutongView> selectListView(Pagination page,@Param("ew") Wrapper<JiazhanggoutongEntity> wrapper);
	
	JiazhanggoutongView selectView(@Param("ew") Wrapper<JiazhanggoutongEntity> wrapper);
	
}
