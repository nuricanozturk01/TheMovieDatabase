package nuricanozturk.dev.tv.data.repository;

import java.util.Optional;
import java.util.function.Predicate;

public interface ICrudRepository <T, PrimaryKey>
{
    long count();
    void delete(T entity);
    void deleteAll();
    void deleteAll(Iterable<? extends  T> entities);
    void deleteById(Iterable<? extends PrimaryKey> ids);
    void deleteById(PrimaryKey id);
    boolean existById(PrimaryKey id);
    Iterable<T> findAll();
    Iterable<T> findAllById(Iterable<PrimaryKey> id);
    Iterable<T> findBy(Predicate<? extends  T> pred);
    Optional<T> finById(PrimaryKey id);
    <S extends T> S save(S entity);
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);
}