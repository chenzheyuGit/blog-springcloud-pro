package com.springcloud.blog.cnblogs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.blog.api.tools.CnBlogsWebServiceApiTools;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/cnblogs",produces = "application/xml;charset=utf-8")
@Api(tags = { "博客园API" }, description = "封装博客园API")
public class CnBlogsWebServiceController {

	/**
	 * 获取48小时排行文章
	 * @param itemCount
	 * @return
	 */
	@GetMapping("/get48HoursTopViewPosts/{itemCount}")
	@ApiOperation("获取48小时排行文章")
	public String get48HoursTopViewPosts(@PathVariable String itemCount) {
		
		return CnBlogsWebServiceApiTools.get48HoursTopViewPosts(itemCount);
	}
	
	
	/**
	 * 分页获取推荐博客列表
	 * @param itemCount
	 * @return
	 */
	@GetMapping("/getRecommend/{pageIndex}/{pageSize}")
	@ApiOperation("分页获取推荐博客列表")
	public String getRecommend(@PathVariable String pageIndex,@PathVariable String pageSize) {
		
		return CnBlogsWebServiceApiTools.getRecommend(pageIndex,pageSize);
	}
	
	/**
	 * 获取推荐博客总数
	 * @return
	 */
	@GetMapping("/getRecommendTotalCount")
	@ApiOperation("获取推荐博客总数")
	public String getRecommendTotalCount() {
		
		return CnBlogsWebServiceApiTools.getRecommendTotalCount();
		
	}
	/**
	 * 根据作者名搜索博主
	 * @param team
	 * @return
	 */
	@GetMapping("/search")
	@ApiOperation("根据作者名搜索博主")
	public String search(String team) {
		
		return CnBlogsWebServiceApiTools.search(team);
		
	}
	
	/**
	 * 获取文章评论
	 * @param postId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/getPostComment/{postId}/comments/{pageIndex}/{pageSize}")
	@ApiOperation("获取文章评论")
	public String getPostComment(@PathVariable String postId,@PathVariable String pageIndex,@PathVariable String pageSize) {
		
		return CnBlogsWebServiceApiTools.getPostComment(postId, pageIndex, pageSize);
		
	}
	/**
	 * 获取文章内容
	 * @param postId
	 * @return
	 */
	@GetMapping("/getPost/{postId}")
	@ApiOperation("获取文章内容")
	public String getPost(@PathVariable String postId) {
		
		return CnBlogsWebServiceApiTools.getPost(postId);
	}
	
	/**
	 * 分页获取首页文章列表
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/getFirstPostListPage/{pageIndex}/{pageSize}")
	@ApiOperation("分页获取首页文章列表")
	public String getFirstPostListPage(@PathVariable String pageIndex,@PathVariable String pageSize) {
		
		return CnBlogsWebServiceApiTools.getFirstPostList(pageIndex, pageSize);
	}
	
	/**
	 * 获取首页文章列表
	 * @param itemCount
	 * @return
	 */
	@GetMapping("/getFirstPostList/{itemCount}")
	@ApiOperation("获取首页文章列表")
	public String getFirstPostList(@PathVariable String itemCount) {
		
		return CnBlogsWebServiceApiTools.getFirstPostList(itemCount);
	}
	
	/**
	 * 10天内推荐排行
	 * @param itemCount
	 * @return
	 */
	@GetMapping("/getTenDaysTopDiggPosts/{itemCount}")
	@ApiOperation("10天内推荐排行")
	public String getTenDaysTopDiggPosts(@PathVariable String itemCount) {
		
		return CnBlogsWebServiceApiTools.getTenDaysTopDiggPosts(itemCount);
	}
	
	/**
	 * 分页获取个人博客文章列表
	 * @param blogapp
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@GetMapping("/getSelfBlogPost/u/{blogapp}/posts/{pageIndex}/{pageSize}")
	@ApiOperation("分页获取个人博客文章列表")
	public String getSelfBlogPost(@PathVariable String blogapp,@PathVariable String pageIndex,@PathVariable String pageSize) {
		
		return CnBlogsWebServiceApiTools.getSelfBlogPost(blogapp, pageIndex, pageSize);
	}
	
}
