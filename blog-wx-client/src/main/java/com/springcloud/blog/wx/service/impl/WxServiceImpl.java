package com.springcloud.blog.wx.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.springcloud.blog.wx.entity.Article;
import com.springcloud.blog.wx.entity.NewsMessage;
import com.springcloud.blog.wx.entity.TextMessage;
import com.springcloud.blog.wx.service.WxService;
import com.springcloud.blog.wx.util.MessageUtil;

/**
 * 微信公众号业务接口实现类
 * 
 * @author youcong
 * @date 2019-5-14 23:54
 *
 */
@Service
public class WxServiceImpl implements WxService {

	@Override
	public String newMessageRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.xmlToMap(request);
			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			// 消息内容
			String content = requestMap.get("Content");

			String resultContent = "";
			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				if ("Java".equals(content)) {
					resultContent = "Java相关框架资料及其基础资料、进阶资料、测试资料之分享:\r\n"
							+ "https://www.cnblogs.com/youcong/p/8905963.html\r\n";
				} else if ("列表".equals(content) || "PHP".equals(content)) {
					resultContent = "精选文章如下\r\n" + "作为程序员的思考与反省:\r\n"
							+ "https://www.cnblogs.com/youcong/p/9862712.html\r\n" + "如何成为一名全栈开发工程师:\r\n"
							+ "https://www.cnblogs.com/youcong/p/10162609.html\r\n" + "推荐在线学习编程网站:\r\n"
							+ "https://www.cnblogs.com/youcong/p/10116530.html" + "架构设计三原则:\r\n"
							+ "https://www.cnblogs.com/youcong/p/10029167.html\r\n" + "SSM框架构建多模块之业务拆分实践:\r\n"
							+ "https://www.cnblogs.com/youcong/p/9715461.html\r\n" + "更多信息可以访问我的博客园:\r\n"
							+ "https://www.cnblogs.com/youcong/" + "\r\n";
				} else if ("分类".equals(content)) {
					resultContent = "精选分类\r\n" + "Docker:\r\n"
							+ "https://www.cnblogs.com/youcong/category/1222243.html\r\n" + "Java:\r\n"
							+ "https://www.cnblogs.com/youcong/category/1341732.html\r\n" + "Java框架:\r\n"
							+ "https://www.cnblogs.com/youcong/category/1102394.html\r\n" + "Linux:\r\n"
							+ "https://www.cnblogs.com/youcong/category/1108764.html\r\n" + "MP实战系列:\r\n"
							+ "https://www.cnblogs.com/youcong/category/1213059.html\r\n" + "MyBatis:\r\n"
							+ "https://www.cnblogs.com/youcong/category/1144041.html\r\n" + "计算机:\r\n"
							+ "https://www.cnblogs.com/youcong/category/1108766.html\r\n" + "更多信息可以访问我的博客园:\r\n"
							+ "https://www.cnblogs.com/youcong/";

				} else if ("电子书".equals(content)) {
					resultContent = "电子书:\r\n" + "https://github.com/developers-youcong/Personal-Learning-Library\r\n"
							+ "我专门将我常常翻阅的电子书上传至上面的GitHub仓库上，如果觉得对你有帮助，可以点一个star或者fork到自己的GitHub上，谢谢\r\n";
				}else {

					resultContent = "欢迎关注我的微信公众号\r\n" + "我的博客园平台:\n" + "https://www.cnblogs.com/youcong\r\n"
							+ "我的Github平台为:\r\n" + "https://github.com/developers-youcong\r\n" + "我的Hexo平台为:\r\n"
							+ "https://developers-youcong.github.io\r\n" + "不定期给大家分享我职业生涯的感触和心得\r\n"
							+ "希望能够给大家带来启发和帮助\r\n" + "回复如下关键字，可获取不一样的信息\r\n" + "1.回复'Java'可获取Java相关的学习教程\r\n"
							+ "2.回复'列表'可获取我的博客精选文章列表\r\n" + "3.回复'分类'可获取我的博客分类及对应的链接\r\n"
							+ "4.回复'电子书'可获取我收集的技术相关电子书\r\n";
				}
				TextMessage text = new TextMessage();
				text.setContent(resultContent);
				text.setToUserName(fromUserName);
				text.setFromUserName(toUserName);
				text.setCreateTime(new Date().getTime());
				text.setMsgType(msgType);
				respMessage = MessageUtil.textMessageToXml(text);

			}else if(msgType.equals(MessageUtil.RESP_MESSAGE_TYPE_NEWS)) {
				if(content.equals("1")) {
					NewsMessage imageMsg = new NewsMessage();
					imageMsg.setFromUserName(fromUserName);
				
					imageMsg.setToUserName(toUserName);
					
					imageMsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
							
					List<Article> articles = new ArrayList<Article>();
					
					Article article = new Article();
					article.setTitle("Java相关框架资料及其基础资料、进阶资料、测试资料之分享");
					article.setDescription("个人说明：只为分享，不为其他，愿所有的程序员们在编程的世界自由翱翔吧!\r\n" + 
							"\r\n" + 
							"在我看来，只有不断实战，不断学习，不断积累，不断归纳总结，形成自己的核心竞争力，方能在未来竞争中脱颖而出！");
					article.setPicUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1560050035&di=1fb524ff28f69db1766ab9a1d53cad86&imgtype=jpg&er=1&src=http%3A%2F%2Fpic23.nipic.com%2F20120918%2F461037_195425463301_2.jpg");
					article.setUrl("https://mp.weixin.qq.com/s?__biz=MzUxODk0ODQ3Ng==&mid=2247483736&idx=1&sn=f56e18620bb1a0ec9a8f49657a788d0e&chksm=f980524bcef7db5d28a32826df3b42e418faa40c16699ac72f993d449db0d7ebb365d4792d3d&token=276204794&lang=zh_CN#rd");
					
					articles.add(article);
					
					imageMsg.setArticles(articles);
					imageMsg.setArticleCount(articles.size());
					
					respMessage = MessageUtil.newsMessageToXml(imageMsg);
			    }
			

			} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {

				String eventType = requestMap.get("Event");// 事件类型
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					// 文本消息
					TextMessage text = new TextMessage();
					text.setContent("欢迎关注我的微信公众号\r\n" + "我的博客园平台:\n" + "https://www.cnblogs.com/youcong\r\n"
							+ "我的Github平台为:\r\n" + "https://github.com/developers-youcong\r\n" + "我的Hexo平台为:\r\n"
							+ "https://developers-youcong.github.io\r\n" + "不定期给大家分享我职业生涯的感触和心得\r\n"
							+ "希望能够给大家带来启发和帮助\r\n" + "回复如下关键字，可获取不一样的信息\r\n" + "1.回复'Java'可获取Java相关的学习教程\r\n"
							+ "2.回复'列表'可获取我的博客精选文章列表\r\n" + "3.回复'分类'可获取我的博客分类及对应的链接\r\n"
							+ "4.回复'电子书'可获取我收集的技术相关电子书\r\n");
					text.setToUserName(fromUserName);
					text.setFromUserName(toUserName);
					text.setCreateTime(new Date().getTime());
					text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					respMessage = MessageUtil.textMessageToXml(text);
				}
				// 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {// 取消订阅

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}

	

}
