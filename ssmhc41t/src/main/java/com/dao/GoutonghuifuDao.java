package com.dao;

import com.entity.GoutonghuifuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GoutonghuifuVO;
import com.entity.view.GoutonghuifuView;


/**
 * 沟通回复
 * 
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
public interface GoutonghuifuDao extends BaseMapper<GoutonghuifuEntity> {
	
	List<GoutonghuifuVO> selectListVO(@Param("ew") Wrapper<GoutonghuifuEntity> wrapper);
	
	GoutonghuifuVO selectVO(@Param("ew") Wrapper<GoutonghuifuEntity> wrapper);
	
	List<GoutonghuifuView> selectListView(@Param("ew") Wrapper<GoutonghuifuEntity> wrapper);

	List<GoutonghuifuView> selectListView(Pagination page,@Param("ew") Wrapper<GoutonghuifuEntity> wrapper);
	
	GoutonghuifuView selectView(@Param("ew") Wrapper<GoutonghuifuEntity> wrapper);
	
}
