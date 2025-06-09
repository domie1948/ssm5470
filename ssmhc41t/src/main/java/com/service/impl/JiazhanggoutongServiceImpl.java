package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JiazhanggoutongDao;
import com.entity.JiazhanggoutongEntity;
import com.service.JiazhanggoutongService;
import com.entity.vo.JiazhanggoutongVO;
import com.entity.view.JiazhanggoutongView;

@Service("jiazhanggoutongService")
public class JiazhanggoutongServiceImpl extends ServiceImpl<JiazhanggoutongDao, JiazhanggoutongEntity> implements JiazhanggoutongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiazhanggoutongEntity> page = this.selectPage(
                new Query<JiazhanggoutongEntity>(params).getPage(),
                new EntityWrapper<JiazhanggoutongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiazhanggoutongEntity> wrapper) {
		  Page<JiazhanggoutongView> page =new Query<JiazhanggoutongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiazhanggoutongVO> selectListVO(Wrapper<JiazhanggoutongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiazhanggoutongVO selectVO(Wrapper<JiazhanggoutongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiazhanggoutongView> selectListView(Wrapper<JiazhanggoutongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiazhanggoutongView selectView(Wrapper<JiazhanggoutongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
