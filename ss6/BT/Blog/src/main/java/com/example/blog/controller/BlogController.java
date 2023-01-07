package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    IBlogService blogService;
    @GetMapping("")
    public String listBlog(Model model){
        model.addAttribute("blogList",blogService.getAll());
        return "list_blog1";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create_blog";
    }
    @PostMapping("/create")
    public String addBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg","Add blog successful");
        return "redirect:/blog";
    }
    @GetMapping("/update")
    public String showEditForm(@RequestParam("codeBlog") String codeBlog,Model model){
        Blog blog = blogService.findByCodeBlog(codeBlog);
        model.addAttribute("blog",blog);
        return "edit_blog";
    }
    @PostMapping("/update")
    public String updateBlog(@ModelAttribute("blog") Blog blog, Model model){
        blogService.update(blog);
        return "redirect:/blog";
    }
    @GetMapping("/delete")
    public String delteBlog(@RequestParam("codeBlog") String codeBlog,Model model){
        blogService.delete(codeBlog);
        return "redirect:/blog";
    }
}
