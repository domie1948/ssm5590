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

import com.entity.XiaoyuanmeishiEntity;
import com.entity.view.XiaoyuanmeishiView;

import com.service.XiaoyuanmeishiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 校园美食
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-02 12:41:47
 */
@RestController
@RequestMapping("/xiaoyuanmeishi")
public class XiaoyuanmeishiController {
    @Autowired
    private XiaoyuanmeishiService xiaoyuanmeishiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaoyuanmeishiEntity xiaoyuanmeishi, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			xiaoyuanmeishi.setShangjiahao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiaoyuanmeishiEntity> ew = new EntityWrapper<XiaoyuanmeishiEntity>();
    	PageUtils page = xiaoyuanmeishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoyuanmeishi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaoyuanmeishiEntity xiaoyuanmeishi, HttpServletRequest request){
        EntityWrapper<XiaoyuanmeishiEntity> ew = new EntityWrapper<XiaoyuanmeishiEntity>();
    	PageUtils page = xiaoyuanmeishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoyuanmeishi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaoyuanmeishiEntity xiaoyuanmeishi){
       	EntityWrapper<XiaoyuanmeishiEntity> ew = new EntityWrapper<XiaoyuanmeishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaoyuanmeishi, "xiaoyuanmeishi")); 
        return R.ok().put("data", xiaoyuanmeishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaoyuanmeishiEntity xiaoyuanmeishi){
        EntityWrapper< XiaoyuanmeishiEntity> ew = new EntityWrapper< XiaoyuanmeishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaoyuanmeishi, "xiaoyuanmeishi")); 
		XiaoyuanmeishiView xiaoyuanmeishiView =  xiaoyuanmeishiService.selectView(ew);
		return R.ok("查询校园美食成功").put("data", xiaoyuanmeishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaoyuanmeishiEntity xiaoyuanmeishi = xiaoyuanmeishiService.selectById(id);
		xiaoyuanmeishi.setClicknum(xiaoyuanmeishi.getClicknum()+1);
		xiaoyuanmeishi.setClicktime(new Date());
		xiaoyuanmeishiService.updateById(xiaoyuanmeishi);
        return R.ok().put("data", xiaoyuanmeishi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaoyuanmeishiEntity xiaoyuanmeishi = xiaoyuanmeishiService.selectById(id);
		xiaoyuanmeishi.setClicknum(xiaoyuanmeishi.getClicknum()+1);
		xiaoyuanmeishi.setClicktime(new Date());
		xiaoyuanmeishiService.updateById(xiaoyuanmeishi);
        return R.ok().put("data", xiaoyuanmeishi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        XiaoyuanmeishiEntity xiaoyuanmeishi = xiaoyuanmeishiService.selectById(id);
        if(type.equals("1")) {
        	xiaoyuanmeishi.setThumbsupnum(xiaoyuanmeishi.getThumbsupnum()+1);
        } else {
        	xiaoyuanmeishi.setCrazilynum(xiaoyuanmeishi.getCrazilynum()+1);
        }
        xiaoyuanmeishiService.updateById(xiaoyuanmeishi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiaoyuanmeishiEntity xiaoyuanmeishi, HttpServletRequest request){
    	xiaoyuanmeishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoyuanmeishi);

        xiaoyuanmeishiService.insert(xiaoyuanmeishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiaoyuanmeishiEntity xiaoyuanmeishi, HttpServletRequest request){
    	xiaoyuanmeishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoyuanmeishi);

        xiaoyuanmeishiService.insert(xiaoyuanmeishi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XiaoyuanmeishiEntity xiaoyuanmeishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaoyuanmeishi);
        xiaoyuanmeishiService.updateById(xiaoyuanmeishi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiaoyuanmeishiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<XiaoyuanmeishiEntity> wrapper = new EntityWrapper<XiaoyuanmeishiEntity>();
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

		int count = xiaoyuanmeishiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,XiaoyuanmeishiEntity xiaoyuanmeishi, HttpServletRequest request,String pre){
        EntityWrapper<XiaoyuanmeishiEntity> ew = new EntityWrapper<XiaoyuanmeishiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = xiaoyuanmeishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoyuanmeishi), params), params));
        return R.ok().put("data", page);
    }


}
