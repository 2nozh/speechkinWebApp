package com.example.speechkin1;

import com.example.speechkin1.models.Post;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class FileWork {
    public static void main(String[] args) {
        try {
            File file1 = new File("D:\\iji\\test.zip");
            FileInputStream input = new FileInputStream(file1);
            MultipartFile multipartFile = new MockMultipartFile("file1",file1.getName(),"text/plain", input);
            Post post = getPost(multipartFile);
            System.out.println("Title:");
            System.out.println(post.getTitle());
            System.out.println("text:");
            System.out.println(post.getBody());
        } catch (Exception e) {
            System.out.println("exception " + e.getMessage());
        }
    }
    private static Post getPost(MultipartFile multipartFile){
        try {
            File tempFile = File.createTempFile("upload",null);
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

    private static String getArchiveContent(File archive){
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(archive));
            while (zipInputStream.getNextEntry()!=null){
                String content =new String(zipInputStream.readAllBytes());
                return content;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    private static Post toPost(String content){
        Post post = new Post();
        String delimeter="\n";
        String[] lines = content.split(delimeter);
        post.setTitle(lines[0]);
        post.setBody(content.substring(lines[0].length()));
        return post;
    }
}
