package controller;

import model.Post;
import repository.GsonPostRepositoryImpl;
import repository.PostRepository;

import java.util.List;

public class PostController {
    private final PostRepository postRepository;

    public PostController() {
        this.postRepository = new GsonPostRepositoryImpl();
    }

    public List<Post> getAll(String line) {
        return null;
    }

    public void createPost(String line) {
    }

    public void updatePost(String line) {
    }

    public Post showPost(String line) {
        return new Post();
    }

    public void deletePost(String line) {
    }
}
