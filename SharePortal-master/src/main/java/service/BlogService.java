package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BlogDao;
import model.Blog;
import model.BlogContent;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogdao;
	
	public void createNewBlog(Blog blog)
	{
		blogdao.createNewBlog(blog);
	}
	
	public List<Blog> getBlogList(String cust_name)
	{
		return blogdao.getBlogList(cust_name);
	}
	
	public void insertPost(BlogContent content)
	{
		blogdao.insertPost(content);
	}
	
	public List<BlogContent> getBlogContent(String blogname)
	{
		return blogdao.getBlogContent(blogname);
	}
}
