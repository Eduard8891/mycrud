package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.NoArgsConstructor;
import model.Label;
import model.Post;
import model.PostStatus;

import javax.xml.crypto.Data;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class GsonPostRepositoryImpl implements PostRepository {
    private final String PATH = Paths.get("src/main/resources/posts.json").toAbsolutePath().toString();
    private final Gson gson = new GsonBuilder().setDateFormat(DateFormat.FULL).create();

    @Override
    public Post get(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        List<Post> allPosts = getAll();
        allPosts.forEach(it -> {
            if (it.getId().equals(id)) {
                it.setStatus(PostStatus.DELETED);
                it.setUpdated(new Date());
            }
        });
        savePosts(allPosts);
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = null;
        Type listOfMyClassObject = new TypeToken<ArrayList<Post>>() {
        }.getType();
        try (Reader reader = new FileReader(PATH)) {
            posts = gson.fromJson(reader, listOfMyClassObject);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return posts;
    }

    @Override
    public Post update(Post post) {
        List <Post> allPosts = getAll();
        allPosts.forEach(it -> {
            if (it.getId().equals(post.getId())) {
                it.setUpdated(new Date());
                it.setStatus(PostStatus.UNDER_REVIEW);
                it.setLabels(post.getLabels());
                it.setContent(post.getContent());
            }
        });
        return post;
    }

    @Override
    public Post create(Post post) {
        List<Post> allPosts = getAll();
        Date date = new Date();
        post.setCreated(date);
        post.setUpdated(date);
        post.setId(getMaxId(allPosts) + 1);
        post.setStatus(PostStatus.ACTIVE);
        allPosts.add(post);
        savePosts(allPosts);
        return post;
    }

    public Integer getMaxId(List<Post> posts) {
        return posts.stream().map(Post::getId).max(Integer::compareTo).orElse(0);
    }

    private void savePosts(List<Post> posts) {
        try (Writer writer = new FileWriter(PATH)) {
            gson.toJson(posts, writer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
