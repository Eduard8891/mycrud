package controller;

import model.Label;
import model.Post;
import repository.GsonLabelRepositoryImpl;
import repository.GsonPostRepositoryImpl;
import repository.LabelRepository;
import repository.PostRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PostController {
    private final PostRepository postRepository;
    private final LabelRepository labelRepository;

    public PostController() {
        this.postRepository = new GsonPostRepositoryImpl();
        this.labelRepository = new GsonLabelRepositoryImpl();
    }

    public List<Post> getAll() {
        return postRepository.getAll();
    }

    public boolean createPost(String body) {
        String content = body.split("___")[0].trim();
        List <Label> allLabels = labelRepository.getAll();
        List <Integer> labelIds = Arrays.stream(body.split("___")[1]
                .replaceAll(" ", "")
                .split(","))
                .map(Integer::valueOf).collect(Collectors.toList());
        if (allLabels.stream().map(Label::getId).collect(Collectors.toList()).containsAll(labelIds)) {
            List <Label> currentLabels = allLabels.stream().filter(it -> labelIds.contains(it.getId())).collect(Collectors.toList());
            Post post = new Post();
            post.setContent(content);
            post.setLabels(currentLabels);
            postRepository.create(post);
            return true;
        } else {
            return false;
        }
    }

    public boolean updatePost(String body) {
        List <Post> allPosts = postRepository.getAll();
        int id = Integer.parseInt(body.split("___")[0]);
        if (allPosts.stream().map(Post::getId).collect(Collectors.toList()).contains(id)) {
            List <Label> allLabels = labelRepository.getAll();
            List <Integer> idsLabels = Arrays
                    .stream(body.split("___")[2].trim().replaceAll(" ", "").split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            if (allLabels.stream().map(Label::getId).collect(Collectors.toList()).containsAll(idsLabels)) {
                List <Label> currentLabels = allLabels.stream().filter(it -> idsLabels.contains(it.getId())).collect(Collectors.toList());
                String content = body.split("___")[1].trim();
                Post post = allPosts.get(id);
                post.setContent(content);
                post.setLabels(currentLabels);
                postRepository.update(post);
                return true;
            }
        }
        return false;
    }

    public void deletePost(Integer id) {
        postRepository.delete(id);
    }
}
