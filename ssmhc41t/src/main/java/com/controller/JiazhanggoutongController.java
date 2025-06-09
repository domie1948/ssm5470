package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiazhanggoutongEntity;
import com.entity.view.JiazhanggoutongView;

import com.service.JiazhanggoutongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 家长沟通
 * 后端接口
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
@RestController
@RequestMapping("/jiazhanggoutong")
public class JiazhanggoutongController {
    @Autowired
    private JiazhanggoutongService jiazhanggoutongService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiazhanggoutongEntity jiazhanggoutong, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiazhang")) {
			jiazhanggoutong.setJiazhangzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiazhanggoutongEntity> ew = new EntityWrapper<JiazhanggoutongEntity>();
		PageUtils page = jiazhanggoutongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiazhanggoutong), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiazhanggoutongEntity jiazhanggoutong, HttpServletRequest request){
        EntityWrapper<JiazhanggoutongEntity> ew = new EntityWrapper<JiazhanggoutongEntity>();
		PageUtils page = jiazhanggoutongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiazhanggoutong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiazhanggoutongEntity jiazhanggoutong){
       	EntityWrapper<JiazhanggoutongEntity> ew = new EntityWrapper<JiazhanggoutongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiazhanggoutong, "jiazhanggoutong")); 
        return R.ok().put("data", jiazhanggoutongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiazhanggoutongEntity jiazhanggoutong){
        EntityWrapper< JiazhanggoutongEntity> ew = new EntityWrapper< JiazhanggoutongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiazhanggoutong, "jiazhanggoutong")); 
		JiazhanggoutongView jiazhanggoutongView =  jiazhanggoutongService.selectView(ew);
		return R.ok("查询家长沟通成功").put("data", jiazhanggoutongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        JiazhanggoutongEntity jiazhanggoutong = jiazhanggoutongService.selectById(id);
        return R.ok().put("data", jiazhanggoutong);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        JiazhanggoutongEntity jiazhanggoutong = jiazhanggoutongService.selectById(id);
        return R.ok().put("data", jiazhanggoutong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiazhanggoutongEntity jiazhanggoutong, HttpServletRequest request){
    	jiazhanggoutong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiazhanggoutong);

        jiazhanggoutongService.insert(jiazhanggoutong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiazhanggoutongEntity jiazhanggoutong, HttpServletRequest request){
    	jiazhanggoutong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiazhanggoutong);

        jiazhanggoutongService.insert(jiazhanggoutong);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JiazhanggoutongEntity jiazhanggoutong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiazhanggoutong);
        jiazhanggoutongService.updateById(jiazhanggoutong);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiazhanggoutongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JiazhanggoutongEntity> wrapper = new EntityWrapper<JiazhanggoutongEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiazhang")) {
			wrapper.eq("jiazhangzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = jiazhanggoutongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
