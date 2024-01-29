package repository;

import java.util.List;

public interface GenericRepository<T, ID> {
    T get(ID id);

    void delete(ID id);

    List<T> getAll();

    void update(T t);

    void create(T t);
}
