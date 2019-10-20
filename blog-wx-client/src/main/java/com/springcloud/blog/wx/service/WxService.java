package com.springcloud.blog.wx.service;

import javax.servlet.http.HttpServletRequest;

import com.springcloud.blog.wx.entity.NewsMessage;

/**
 * 微信公众号业务接口
 * @author youcong
 * @date 2019-5-14 23:54
 *
 */
public interface WxService {
	
   /**
    * 微信公众号处理(关注微信公众号，推送对应的消息)
    * @param request
    * @return
    */
   String newMessageRequest(HttpServletRequest request);

}
