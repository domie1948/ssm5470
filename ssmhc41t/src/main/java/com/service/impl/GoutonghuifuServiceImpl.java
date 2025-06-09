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


import com.dao.GoutonghuifuDao;
import com.entity.GoutonghuifuEntity;
import com.service.GoutonghuifuService;
import com.entity.vo.GoutonghuifuVO;
import com.entity.view.GoutonghuifuView;

@Service("goutonghuifuService")
public class GoutonghuifuServiceImpl extends ServiceImpl<GoutonghuifuDao, GoutonghuifuEntity> implements GoutonghuifuService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoutonghuifuEntity> page = this.selectPage(
                new Query<GoutonghuifuEntity>(params).getPage(),
                new EntityWrapper<GoutonghuifuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GoutonghuifuEntity> wrapper) {
		  Page<GoutonghuifuView> page =new Query<GoutonghuifuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<GoutonghuifuVO> selectListVO(Wrapper<GoutonghuifuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoutonghuifuVO selectVO(Wrapper<GoutonghuifuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GoutonghuifuView> selectListView(Wrapper<GoutonghuifuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoutonghuifuView selectView(Wrapper<GoutonghuifuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
