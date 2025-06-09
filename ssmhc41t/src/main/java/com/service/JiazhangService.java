package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiazhangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiazhangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiazhangView;


/**
 * 家长
 *
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
public interface JiazhangService extends IService<JiazhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiazhangVO> selectListVO(Wrapper<JiazhangEntity> wrapper);
   	
   	JiazhangVO selectVO(@Param("ew") Wrapper<JiazhangEntity> wrapper);
   	
   	List<JiazhangView> selectListView(Wrapper<JiazhangEntity> wrapper);
   	
   	JiazhangView selectView(@Param("ew") Wrapper<JiazhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiazhangEntity> wrapper);
   	
}

