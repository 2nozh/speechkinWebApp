package com.example.speechkin1.controllers;


import com.example.speechkin1.dao.PostDAO;
import com.example.speechkin1.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@Controller
@RequestMapping("/posts/newPost")
public class FileUploadController {
    @Autowired
    private PostDAO postDAO;

    @GetMapping("")
    public String provideUploadInfo() {
        return "posts/newPost";
    }

    @PostMapping("")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   Model model){
        postDAO.addPost(file);
        return "redirect:/posts";
    }
        /*



    /*public String handleFileUpload(@RequestParam("name") String name,
                                   @RequestParam("file") MultipartFile file,
                                    Model model) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(name + "-uploaded"));
                stream.write(bytes);
                stream.close();
                model.addAttribute("message","uploaded successfully " + name);
                return "posts/upload";

            } catch (Exception e) {
                model.addAttribute("message","failed upload " + name);
                return "posts/upload";
            }
        } else {
            model.addAttribute("message","file " + name+ "empty");
            return "posts/upload";
        }
    }*/

}
