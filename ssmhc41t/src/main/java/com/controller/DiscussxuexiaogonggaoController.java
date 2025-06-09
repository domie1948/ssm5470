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

import com.entity.DiscussxuexiaogonggaoEntity;
import com.entity.view.DiscussxuexiaogonggaoView;

import com.service.DiscussxuexiaogonggaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 学校公告评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
@RestController
@RequestMapping("/discussxuexiaogonggao")
public class DiscussxuexiaogonggaoController {
    @Autowired
    private DiscussxuexiaogonggaoService discussxuexiaogonggaoService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussxuexiaogonggaoEntity discussxuexiaogonggao, HttpServletRequest request){

        EntityWrapper<DiscussxuexiaogonggaoEntity> ew = new EntityWrapper<DiscussxuexiaogonggaoEntity>();
		PageUtils page = discussxuexiaogonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxuexiaogonggao), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussxuexiaogonggaoEntity discussxuexiaogonggao, HttpServletRequest request){
        EntityWrapper<DiscussxuexiaogonggaoEntity> ew = new EntityWrapper<DiscussxuexiaogonggaoEntity>();
		PageUtils page = discussxuexiaogonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxuexiaogonggao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussxuexiaogonggaoEntity discussxuexiaogonggao){
       	EntityWrapper<DiscussxuexiaogonggaoEntity> ew = new EntityWrapper<DiscussxuexiaogonggaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussxuexiaogonggao, "discussxuexiaogonggao")); 
        return R.ok().put("data", discussxuexiaogonggaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussxuexiaogonggaoEntity discussxuexiaogonggao){
        EntityWrapper< DiscussxuexiaogonggaoEntity> ew = new EntityWrapper< DiscussxuexiaogonggaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussxuexiaogonggao, "discussxuexiaogonggao")); 
		DiscussxuexiaogonggaoView discussxuexiaogonggaoView =  discussxuexiaogonggaoService.selectView(ew);
		return R.ok("查询学校公告评论表成功").put("data", discussxuexiaogonggaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussxuexiaogonggaoEntity discussxuexiaogonggao = discussxuexiaogonggaoService.selectById(id);
        return R.ok().put("data", discussxuexiaogonggao);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussxuexiaogonggaoEntity discussxuexiaogonggao = discussxuexiaogonggaoService.selectById(id);
        return R.ok().put("data", discussxuexiaogonggao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussxuexiaogonggaoEntity discussxuexiaogonggao, HttpServletRequest request){
    	discussxuexiaogonggao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxuexiaogonggao);

        discussxuexiaogonggaoService.insert(discussxuexiaogonggao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussxuexiaogonggaoEntity discussxuexiaogonggao, HttpServletRequest request){
    	discussxuexiaogonggao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxuexiaogonggao);

        discussxuexiaogonggaoService.insert(discussxuexiaogonggao);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussxuexiaogonggaoEntity discussxuexiaogonggao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussxuexiaogonggao);
        discussxuexiaogonggaoService.updateById(discussxuexiaogonggao);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussxuexiaogonggaoService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscussxuexiaogonggaoEntity> wrapper = new EntityWrapper<DiscussxuexiaogonggaoEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussxuexiaogonggaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
