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


import com.dao.YuankuangjieshaoDao;
import com.entity.YuankuangjieshaoEntity;
import com.service.YuankuangjieshaoService;
import com.entity.vo.YuankuangjieshaoVO;
import com.entity.view.YuankuangjieshaoView;

@Service("yuankuangjieshaoService")
public class YuankuangjieshaoServiceImpl extends ServiceImpl<YuankuangjieshaoDao, YuankuangjieshaoEntity> implements YuankuangjieshaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuankuangjieshaoEntity> page = this.selectPage(
                new Query<YuankuangjieshaoEntity>(params).getPage(),
                new EntityWrapper<YuankuangjieshaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuankuangjieshaoEntity> wrapper) {
		  Page<YuankuangjieshaoView> page =new Query<YuankuangjieshaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YuankuangjieshaoVO> selectListVO(Wrapper<YuankuangjieshaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuankuangjieshaoVO selectVO(Wrapper<YuankuangjieshaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuankuangjieshaoView> selectListView(Wrapper<YuankuangjieshaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuankuangjieshaoView selectView(Wrapper<YuankuangjieshaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
