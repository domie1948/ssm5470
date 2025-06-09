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


import com.dao.DiscussxuexiaogonggaoDao;
import com.entity.DiscussxuexiaogonggaoEntity;
import com.service.DiscussxuexiaogonggaoService;
import com.entity.vo.DiscussxuexiaogonggaoVO;
import com.entity.view.DiscussxuexiaogonggaoView;

@Service("discussxuexiaogonggaoService")
public class DiscussxuexiaogonggaoServiceImpl extends ServiceImpl<DiscussxuexiaogonggaoDao, DiscussxuexiaogonggaoEntity> implements DiscussxuexiaogonggaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxuexiaogonggaoEntity> page = this.selectPage(
                new Query<DiscussxuexiaogonggaoEntity>(params).getPage(),
                new EntityWrapper<DiscussxuexiaogonggaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxuexiaogonggaoEntity> wrapper) {
		  Page<DiscussxuexiaogonggaoView> page =new Query<DiscussxuexiaogonggaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussxuexiaogonggaoVO> selectListVO(Wrapper<DiscussxuexiaogonggaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussxuexiaogonggaoVO selectVO(Wrapper<DiscussxuexiaogonggaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussxuexiaogonggaoView> selectListView(Wrapper<DiscussxuexiaogonggaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxuexiaogonggaoView selectView(Wrapper<DiscussxuexiaogonggaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
