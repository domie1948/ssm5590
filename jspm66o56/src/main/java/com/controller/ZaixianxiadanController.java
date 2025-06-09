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

import com.entity.ZaixianxiadanEntity;
import com.entity.view.ZaixianxiadanView;

import com.service.ZaixianxiadanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 在线下单
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-02 12:41:47
 */
@RestController
@RequestMapping("/zaixianxiadan")
public class ZaixianxiadanController {
    @Autowired
    private ZaixianxiadanService zaixianxiadanService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZaixianxiadanEntity zaixianxiadan, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			zaixianxiadan.setShangjiahao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			zaixianxiadan.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZaixianxiadanEntity> ew = new EntityWrapper<ZaixianxiadanEntity>();
    	PageUtils page = zaixianxiadanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianxiadan), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZaixianxiadanEntity zaixianxiadan, HttpServletRequest request){
        EntityWrapper<ZaixianxiadanEntity> ew = new EntityWrapper<ZaixianxiadanEntity>();
    	PageUtils page = zaixianxiadanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianxiadan), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZaixianxiadanEntity zaixianxiadan){
       	EntityWrapper<ZaixianxiadanEntity> ew = new EntityWrapper<ZaixianxiadanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zaixianxiadan, "zaixianxiadan")); 
        return R.ok().put("data", zaixianxiadanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZaixianxiadanEntity zaixianxiadan){
        EntityWrapper< ZaixianxiadanEntity> ew = new EntityWrapper< ZaixianxiadanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zaixianxiadan, "zaixianxiadan")); 
		ZaixianxiadanView zaixianxiadanView =  zaixianxiadanService.selectView(ew);
		return R.ok("查询在线下单成功").put("data", zaixianxiadanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZaixianxiadanEntity zaixianxiadan = zaixianxiadanService.selectById(id);
        return R.ok().put("data", zaixianxiadan);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZaixianxiadanEntity zaixianxiadan = zaixianxiadanService.selectById(id);
        return R.ok().put("data", zaixianxiadan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZaixianxiadanEntity zaixianxiadan, HttpServletRequest request){
    	zaixianxiadan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianxiadan);

        zaixianxiadanService.insert(zaixianxiadan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZaixianxiadanEntity zaixianxiadan, HttpServletRequest request){
    	zaixianxiadan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianxiadan);

        zaixianxiadanService.insert(zaixianxiadan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZaixianxiadanEntity zaixianxiadan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zaixianxiadan);
        zaixianxiadanService.updateById(zaixianxiadan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zaixianxiadanService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZaixianxiadanEntity> wrapper = new EntityWrapper<ZaixianxiadanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			wrapper.eq("shangjiahao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = zaixianxiadanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
