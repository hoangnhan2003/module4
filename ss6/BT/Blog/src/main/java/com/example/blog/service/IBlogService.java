package com.example.blog.service;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<BlogDto> getAll();
    Blog findByTitle(String title);
    Blog findByCodeBlog(String codeBlog);
    void save(Blog blog);
    void delete(String codeBlog);
    void update(Blog blog);
}
