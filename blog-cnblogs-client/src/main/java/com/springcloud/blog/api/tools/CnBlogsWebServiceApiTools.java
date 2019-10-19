package com.springcloud.blog.api.tools;

import cn.hutool.http.HttpUtil;

public class CnBlogsWebServiceApiTools {

	/**
	 * 博客园API
	 */
	public static final String cnblog_api = "http://wcf.open.cnblogs.com/blog";

	/**
	 * 48小时阅读排行
	 * 
	 * @param itemCount
	 * @return
	 */
	public static String get48HoursTopViewPosts(String itemCount) {

		String result = HttpUtil.get(CnBlogsWebServiceApiTools.cnblog_api + "/48HoursTopViewPosts/" + itemCount);

		return result;
	}

	/**
	 * 分页获取推荐博客列表
	 * 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public static String getRecommend(String pageIndex, String pageSize) {

		String result = HttpUtil
				.get(CnBlogsWebServiceApiTools.cnblog_api + "/bloggers/recommend/" + pageIndex + "/" + pageSize);

		return result;

	}

	/**
	 * 获取推荐博客总数
	 * 
	 * @return
	 */
	public static String getRecommendTotalCount() {

		String result = HttpUtil.get(CnBlogsWebServiceApiTools.cnblog_api + "/bloggers/recommend/count");

		return result;

	}
	
	
	/**
	 * 根据作者名搜索博客
	 * @param team
	 * @return
	 */
	public static String search(String team) {

		String result = HttpUtil.get(CnBlogsWebServiceApiTools.cnblog_api + "/bloggers/search?t="+team);

		return result;

	}
	
	
	/**
	 * 获取文章评论
	 * @param postId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public static String getPostComment(String postId,String pageIndex,String pageSize) {

		String result = HttpUtil.get(CnBlogsWebServiceApiTools.cnblog_api + "/post/"+postId+"/comments/"+pageIndex+"/"+pageSize);

		return result;

	}

	
	/**
	 * 获取文章内容
	 * @param postId
	 * @return
	 */
	public static String getPost(String postId) {

		String result = HttpUtil.get(CnBlogsWebServiceApiTools.cnblog_api + "/post/body/"+postId);

		return result;

	}
	
	
	/**
	 * 获取首页文章分页列表
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public static String getFirstPostList(String pageIndex,String pageSize) {

		String result = HttpUtil.get(CnBlogsWebServiceApiTools.cnblog_api + "/sitehome/paged/"+pageIndex+"/"+pageSize);

		return result;

	}
	
	/**
	 * 	获取首页文章列表
	 * @param itemcount
	 * @return
	 */
	public static String getFirstPostList(String itemCount) {

		String result = HttpUtil.get(CnBlogsWebServiceApiTools.cnblog_api + "/sitehome/recent/"+itemCount);

		return result;

	}
	
	/**
	 * 10天内推荐排行
	 * @param itemCount
	 * @return
	 */
	public static String getTenDaysTopDiggPosts(String itemCount) {

		String result = HttpUtil.get(CnBlogsWebServiceApiTools.cnblog_api + "/TenDaysTopDiggPosts/"+itemCount);
		

		return result;

	}
	
	
	/**
	 * 分页获取个人博客文章列表
	 * @param blogapp
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public static String getSelfBlogPost(String blogapp,String pageIndex,String pageSize) {

		String result = HttpUtil.get(CnBlogsWebServiceApiTools.cnblog_api + "u/"+blogapp+"/posts/"+pageIndex+"/"+pageSize);
		

		return result;

	}
	
	
	
	
}

	
	

