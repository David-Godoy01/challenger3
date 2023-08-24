package com.challenge3.compass.challenge3.controller;

import com.challenge3.compass.challenge3.api.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerAPI {
/*
    private final ClientAPI clientAPI;

    public ControllerAPI(ClientAPI clientAPI) {
        this.clientAPI = clientAPI;
    }

    @GetMapping("/posts")
    public Post[] allPosts() {
       return clientAPI.getPosts();
    }
*/

    @GetMapping("posts/{postId}")
    public Post postId(@PathVariable("postId") String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Post> postid =
                restTemplate
                        .getForEntity(
                                String.format("https://jsonplaceholder.typicode.com/posts/%s", id),
                                Post.class);
        return postid.getBody();
    }



}
