package com.example.speechkin1.dao;

import com.example.speechkin1.models.Post;
import com.example.speechkin1.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostDAO {

    private final PostsRepository postsRepository;

    @Autowired
    public PostDAO(PostsRepository postsRepository){
        this.postsRepository=postsRepository;
    }

    public static int COUNT;

    private List<Post> posts;

    {
        posts = new ArrayList<>();
        posts.add(new Post((++COUNT), "header1", "texttext1text1111111text111111111111"));
        posts.add(new Post((++COUNT), "header2", "texttext2222222222222222222222222222"));
        posts.add(new Post((++COUNT), "header3", "texttext3333333333333333333333333333"));
        posts.add(new Post((++COUNT), "header4", "texttext444444444444444444444444444444444444444444444444444"));
    }

    public List<Post> getAllPosts() {

        return postsRepository.findAll();
    }

    public Post getPostById(int id) {
        return posts.stream().filter(post -> post.getId() == id).findAny().orElse(null);
    }

    public void addPost(Post post){
        posts.add(new Post((++COUNT),post.getTitle(),post.getBody()));
    }
    public void addPost(MultipartFile file){
        FileConvert fileConvert = new FileConvert();
        addPost(fileConvert.getPost(file));
    }
}
