package com.example.speechkin1.dao;

import com.example.speechkin1.models.Post;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;


public class FileConvert {

    public Post getPost(MultipartFile multipartFile) {
        try {
            File tempFile = File.createTempFile("upload", null);
            multipartFile.transferTo(tempFile);
            String content = getArchiveContent(tempFile);
            tempFile.delete();
            Post post = toPost(content);
            return post;
        } catch (Exception e) {
            System.out.println("exception " + e.getMessage());
        }
        return null;
    }

    public String getArchiveContent(File archive) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(archive));
            while (zipInputStream.getNextEntry() != null) {
                String content = new String(zipInputStream.readAllBytes());
                return content;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Post toPost(String content) {
        Post post = new Post();
        String delimeter = "\n";
        String[] lines = content.split(delimeter);
        post.setTitle(lines[0]);
        post.setBody(content.substring(lines[0].length()));
        return post;
    }
}
