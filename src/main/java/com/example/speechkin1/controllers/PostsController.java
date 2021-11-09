package com.example.speechkin1.controllers;

import com.example.speechkin1.dao.PostDAO;
import com.example.speechkin1.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostDAO postDAO;

    @GetMapping("/upload")
    public String provideUploadInfo() {
        return "posts/upload";
    }


    @GetMapping()
    public String allPosts(Model model){
        model.addAttribute("posts",postDAO.getAllPosts());
        return "posts/allPosts";
    }

    @GetMapping("/{id}")
    public String showPost(@PathVariable("id") int id, Model model){
        model.addAttribute("post",postDAO.getPostById(id));
        return "posts/postById";
    }

    @GetMapping("/newPost")
    public  String newPost(Model model){
        model.addAttribute("post", new Post());
        return "posts/newPost";
    }


     @PostMapping("")
    public  String create(@ModelAttribute("post") Post post){
        postDAO.addPost(post);
        return "redirect:/posts";
     }

}
