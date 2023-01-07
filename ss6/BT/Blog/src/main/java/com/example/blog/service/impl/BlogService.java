package com.example.blog.service.impl;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<BlogDto> getAll() {
        List<Blog> blogList = blogRepository.findAll();
        List<BlogDto> blogDtoList = new ArrayList<>();
        BlogDto blogDto;
        for(Blog blog: blogList){
            blogDto = new BlogDto();
            BeanUtils.copyProperties(blog,blogDto);
            blogDtoList.add(blogDto);
        }
        return blogDtoList;
    }

    @Override
    public Blog findByTitle(String title) {
        return blogRepository.findBlogByTitle(title);
    }

    @Override
    public Blog findByCodeBlog(String codeBlog) {
        return blogRepository.findBlogByCodeBlog(codeBlog);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(String codeBlog) {
        blogRepository.deleteByCodeBlog(codeBlog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }
}
