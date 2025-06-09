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


import com.dao.DiscussyuankuangjieshaoDao;
import com.entity.DiscussyuankuangjieshaoEntity;
import com.service.DiscussyuankuangjieshaoService;
import com.entity.vo.DiscussyuankuangjieshaoVO;
import com.entity.view.DiscussyuankuangjieshaoView;

@Service("discussyuankuangjieshaoService")
public class DiscussyuankuangjieshaoServiceImpl extends ServiceImpl<DiscussyuankuangjieshaoDao, DiscussyuankuangjieshaoEntity> implements DiscussyuankuangjieshaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyuankuangjieshaoEntity> page = this.selectPage(
                new Query<DiscussyuankuangjieshaoEntity>(params).getPage(),
                new EntityWrapper<DiscussyuankuangjieshaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyuankuangjieshaoEntity> wrapper) {
		  Page<DiscussyuankuangjieshaoView> page =new Query<DiscussyuankuangjieshaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussyuankuangjieshaoVO> selectListVO(Wrapper<DiscussyuankuangjieshaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyuankuangjieshaoVO selectVO(Wrapper<DiscussyuankuangjieshaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyuankuangjieshaoView> selectListView(Wrapper<DiscussyuankuangjieshaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyuankuangjieshaoView selectView(Wrapper<DiscussyuankuangjieshaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
