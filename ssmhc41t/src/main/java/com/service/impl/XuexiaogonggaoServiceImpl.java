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


import com.dao.XuexiaogonggaoDao;
import com.entity.XuexiaogonggaoEntity;
import com.service.XuexiaogonggaoService;
import com.entity.vo.XuexiaogonggaoVO;
import com.entity.view.XuexiaogonggaoView;

@Service("xuexiaogonggaoService")
public class XuexiaogonggaoServiceImpl extends ServiceImpl<XuexiaogonggaoDao, XuexiaogonggaoEntity> implements XuexiaogonggaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuexiaogonggaoEntity> page = this.selectPage(
                new Query<XuexiaogonggaoEntity>(params).getPage(),
                new EntityWrapper<XuexiaogonggaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuexiaogonggaoEntity> wrapper) {
		  Page<XuexiaogonggaoView> page =new Query<XuexiaogonggaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XuexiaogonggaoVO> selectListVO(Wrapper<XuexiaogonggaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XuexiaogonggaoVO selectVO(Wrapper<XuexiaogonggaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XuexiaogonggaoView> selectListView(Wrapper<XuexiaogonggaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuexiaogonggaoView selectView(Wrapper<XuexiaogonggaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
