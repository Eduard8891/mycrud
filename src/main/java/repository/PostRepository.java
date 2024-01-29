package repository;

import model.Writer;

import java.util.List;

public interface PostRepository extends GenericRepository<Writer, Integer> {
    @Override
    Writer get(Integer id);

    @Override
    void delete(Integer id);

    @Override
    List<Writer> getAll();

    @Override
    void update(Writer writer);

    @Override
    void create(Writer writer);
}
