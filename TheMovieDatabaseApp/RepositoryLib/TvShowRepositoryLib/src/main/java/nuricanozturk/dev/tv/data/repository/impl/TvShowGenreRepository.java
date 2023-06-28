package nuricanozturk.dev.tv.data.repository.impl;

import nuricanozturk.dev.tv.data.entity.TvShowGenre;
import nuricanozturk.dev.tv.data.repository.ITvShowGenreRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Predicate;

@Repository("nuricanozturk.dev.tv.data.tvShowGenreRepository")
@Lazy
public class TvShowGenreRepository implements ITvShowGenreRepository
{

    @Override
    public long count()
    {
        return 0;
    }

    @Override
    public void delete(TvShowGenre entity)
    {

    }

    @Override
    public void deleteAll()
    {

    }

    @Override
    public void deleteAll(Iterable<? extends TvShowGenre> entities)
    {

    }

    @Override
    public void deleteById(Iterable<? extends Integer> ids)
    {

    }

    @Override
    public void deleteById(Integer id)
    {

    }

    @Override
    public boolean existById(Integer id)
    {
        return false;
    }

    @Override
    public Iterable<TvShowGenre> findAll()
    {
        return null;
    }

    @Override
    public Iterable<TvShowGenre> findAllById(Iterable<Integer> id)
    {
        return null;
    }

    @Override
    public Iterable<TvShowGenre> findBy(Predicate<? extends TvShowGenre> pred)
    {
        return null;
    }

    @Override
    public Optional<TvShowGenre> finById(Integer id)
    {
        return Optional.empty();
    }

    @Override
    public <S extends TvShowGenre> S save(S entity)
    {
        return null;
    }

    @Override
    public <S extends TvShowGenre> Iterable<S> saveAll(Iterable<S> entities)
    {
        return null;
    }
}
