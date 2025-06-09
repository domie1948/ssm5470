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

import com.entity.GoutonghuifuEntity;
import com.entity.view.GoutonghuifuView;

import com.service.GoutonghuifuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 沟通回复
 * 后端接口
 * @author 
 * @email 
 * @date 2020-12-31 10:07:25
 */
@RestController
@RequestMapping("/goutonghuifu")
public class GoutonghuifuController {
    @Autowired
    private GoutonghuifuService goutonghuifuService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GoutonghuifuEntity goutonghuifu, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiazhang")) {
			goutonghuifu.setJiazhangzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("laoshi")) {
			goutonghuifu.setLaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GoutonghuifuEntity> ew = new EntityWrapper<GoutonghuifuEntity>();
		PageUtils page = goutonghuifuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, goutonghuifu), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GoutonghuifuEntity goutonghuifu, HttpServletRequest request){
        EntityWrapper<GoutonghuifuEntity> ew = new EntityWrapper<GoutonghuifuEntity>();
		PageUtils page = goutonghuifuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, goutonghuifu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GoutonghuifuEntity goutonghuifu){
       	EntityWrapper<GoutonghuifuEntity> ew = new EntityWrapper<GoutonghuifuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( goutonghuifu, "goutonghuifu")); 
        return R.ok().put("data", goutonghuifuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GoutonghuifuEntity goutonghuifu){
        EntityWrapper< GoutonghuifuEntity> ew = new EntityWrapper< GoutonghuifuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( goutonghuifu, "goutonghuifu")); 
		GoutonghuifuView goutonghuifuView =  goutonghuifuService.selectView(ew);
		return R.ok("查询沟通回复成功").put("data", goutonghuifuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        GoutonghuifuEntity goutonghuifu = goutonghuifuService.selectById(id);
        return R.ok().put("data", goutonghuifu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        GoutonghuifuEntity goutonghuifu = goutonghuifuService.selectById(id);
        return R.ok().put("data", goutonghuifu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GoutonghuifuEntity goutonghuifu, HttpServletRequest request){
    	goutonghuifu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(goutonghuifu);

        goutonghuifuService.insert(goutonghuifu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GoutonghuifuEntity goutonghuifu, HttpServletRequest request){
    	goutonghuifu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(goutonghuifu);

        goutonghuifuService.insert(goutonghuifu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody GoutonghuifuEntity goutonghuifu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(goutonghuifu);
        goutonghuifuService.updateById(goutonghuifu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        goutonghuifuService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<GoutonghuifuEntity> wrapper = new EntityWrapper<GoutonghuifuEntity>();
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
		if(tableName.equals("laoshi")) {
			wrapper.eq("laoshigonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = goutonghuifuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
