package com.dao;

import com.entity.JiazhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiazhangVO;
import com.entity.view.JiazhangView;


/**
 * 家长
 * 
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
public interface JiazhangDao extends BaseMapper<JiazhangEntity> {
	
	List<JiazhangVO> selectListVO(@Param("ew") Wrapper<JiazhangEntity> wrapper);
	
	JiazhangVO selectVO(@Param("ew") Wrapper<JiazhangEntity> wrapper);
	
	List<JiazhangView> selectListView(@Param("ew") Wrapper<JiazhangEntity> wrapper);

	List<JiazhangView> selectListView(Pagination page,@Param("ew") Wrapper<JiazhangEntity> wrapper);
	
	JiazhangView selectView(@Param("ew") Wrapper<JiazhangEntity> wrapper);
	
}
