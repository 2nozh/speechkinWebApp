package com.example.speechkin1.dao;

import com.example.speechkin1.models.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostDAO {

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
        return posts;
    }

    public Post getPostById(int id) {
        return posts.stream().filter(post -> post.getId() == id).findAny().orElse(null);
    }

    public void addPost(Post post){
        posts.add(new Post((++COUNT),post.getTitle(),post.getBody()));
    }
}
