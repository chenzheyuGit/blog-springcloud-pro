package com.springcloud.blog.wx.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
/**
 * 
 * @author youcong
 * @date 2019-5-14 23:53
 * 微信公众号专用工具类
 */
public class WxUtil {

	
	public static JSONObject parseJSON(String data) {
    
		return (JSONObject) JSONUtil.parse(data);
	}
}
