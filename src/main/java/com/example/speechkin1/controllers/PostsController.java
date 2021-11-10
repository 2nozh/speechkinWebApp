package com.example.speechkin1.controllers;

import com.example.speechkin1.dao.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostDAO postDAO;

    @GetMapping()
    public String allPosts(Model model) {
        model.addAttribute("posts", postDAO.getAllPosts());
        return "posts/allPosts";
    }

    @GetMapping("/{id}")
    public String showPost(@PathVariable("id") int id, Model model) {
        model.addAttribute("post", postDAO.getPostById(id));
        return "posts/postById";
    }

}
