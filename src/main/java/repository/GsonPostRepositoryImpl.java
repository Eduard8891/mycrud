package repository;

import com.google.gson.Gson;
import model.Post;

import java.util.List;

public class GsonPostRepositoryImpl implements PostRepository {

    private final Gson gson = new Gson();

    public GsonPostRepositoryImpl() {
    }

    @Override
    public Post get(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public List<Post> getAll() {
        return null;
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public Post create(Post post) {
        return null;
    }
}
