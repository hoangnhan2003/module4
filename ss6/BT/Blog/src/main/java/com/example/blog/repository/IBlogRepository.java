package com.example.blog.repository;


import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog,String> {
    Blog findBlogByTitle(String title);
    Blog findBlogByCodeBlog(String codeBlog);

    void deleteByCodeBlog(String codeBlog);


}
