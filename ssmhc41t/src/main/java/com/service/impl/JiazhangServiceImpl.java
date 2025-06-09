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


import com.dao.JiazhangDao;
import com.entity.JiazhangEntity;
import com.service.JiazhangService;
import com.entity.vo.JiazhangVO;
import com.entity.view.JiazhangView;

@Service("jiazhangService")
public class JiazhangServiceImpl extends ServiceImpl<JiazhangDao, JiazhangEntity> implements JiazhangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiazhangEntity> page = this.selectPage(
                new Query<JiazhangEntity>(params).getPage(),
                new EntityWrapper<JiazhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiazhangEntity> wrapper) {
		  Page<JiazhangView> page =new Query<JiazhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiazhangVO> selectListVO(Wrapper<JiazhangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiazhangVO selectVO(Wrapper<JiazhangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiazhangView> selectListView(Wrapper<JiazhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiazhangView selectView(Wrapper<JiazhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
