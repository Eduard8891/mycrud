package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Writer;

import java.nio.file.Paths;
import java.util.List;

public class GsonWriterRepositoryImpl implements WriterRepository {
    private final String PATH = Paths.get("src/main/resources/writers.json").toAbsolutePath().toString();

    private final Gson gson = new Gson();

    public GsonWriterRepositoryImpl() {
    }

    @Override
    public Writer get(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Writer> getAll() {
        return null;
    }

    @Override
    public Writer update(Writer writer) {
        return null;
    }

    @Override
    public Writer create(Writer writer) {
        return null;
    }
}
