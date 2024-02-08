package controller;

import model.Post;
import model.Writer;
import repository.gson.GsonPostRepositoryImpl;
import repository.gson.GsonWriterRepositoryImpl;
import repository.PostRepository;
import repository.WriterRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WriterController {
    private final WriterRepository writerRepository;
    private final PostRepository postRepository;

    public WriterController() {
        this.writerRepository = new GsonWriterRepositoryImpl();
        this.postRepository = new GsonPostRepositoryImpl();
    }

    public List<Writer> getAll() {
        return writerRepository.getAll();
    }

    public boolean createWriter(String body) {
        if (body.split(" ").length == 3) {
            String postsLine = body.split(" ")[2];
            List<Post> currentPosts = getPosts(postsLine);
            if (currentPosts != null) {
                List<Writer> writers = getAll();
                Writer current = writers.stream()
                        .filter(it -> it.getFirstName().equalsIgnoreCase(body.split(" ")[0]) && it.getLastName().equalsIgnoreCase(body.split(" ")[1]))
                        .findFirst()
                        .orElse(null);
                if (current == null) {
                    Writer writer = new Writer();
                    writer.setFirstName(body.split(" ")[0]);
                    writer.setLastName(body.split(" ")[1]);
                    writer.setPosts(currentPosts);
                    writerRepository.create(writer);
                    return true;
                } else {
                    writerRepository.create(current);
                    return true;
                }
            }
        }
        return false;
    }

    private List<Post> getPosts(String body) {
        List<Post> currentPosts = new ArrayList<>();
        List<Post> allPosts = postRepository.getAll();

        List <Integer> idsPosts = Arrays.stream(body.split(",")).map(Integer::valueOf).collect(Collectors.toList());

        if (!allPosts.isEmpty()) {
            allPosts.forEach(it -> {
                if (idsPosts.contains(it.getId())) {
                    currentPosts.add(it);
                }
            });
        }
        if (body.split(",").length == currentPosts.size()) {
            return currentPosts;
        }
        return null;
    }

    public void deleteWriter(Integer id) {
        writerRepository.delete(id);
    }
}
