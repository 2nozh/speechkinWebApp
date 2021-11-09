package com.example.speechkin1.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@Controller
public class FileUploadController {
    @GetMapping("/upload")
    public String provideUploadInfo() {
        return "posts/upload";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   Model model){
        System.out.println("file uploaded");
        System.out.println(file.getContentType());
        try {
            System.out.println("filename" + file.getName());
            System.out.println("filesize " + file.getSize());
        }catch (Exception e){
            System.out.println("error" + e.getMessage());
        }


        if (true) {
            try {

                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream( "uploadedfile"));
                stream.write(bytes);

                System.out.println("uploaded successfully");
                System.out.println(stream);
                stream.close();
                return ("/posts/allPosts");

            } catch (Exception e) {
                System.out.println("fail1 "+ e.getMessage());
                return ("/posts/allPosts");
            }
        } else {
            System.out.println("fail2");
            return ("/posts/allPosts");
        }

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
