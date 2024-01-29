package controller;

import model.Post;
import view.LabelView;
import view.PostView;

import java.util.List;

public class PostController {
    private final PostView view;

    public PostController(PostView view) {
        this.view = view;
    }

    public void selectCommand(String line) {
        String command = line.split(" ")[0];
        switch (command) {
            case "Создать":
                createPost(line);
            case "Удалить":
                deletePost(line);
            case "Обновить":
                updatePost(line);
            case "Показать":
                showPost(line);
            default:
                view.errorText(line);
        }
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
