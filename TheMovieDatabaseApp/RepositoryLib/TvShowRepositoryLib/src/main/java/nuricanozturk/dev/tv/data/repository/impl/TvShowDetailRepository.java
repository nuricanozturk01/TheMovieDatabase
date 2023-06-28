package nuricanozturk.dev.tv.data.repository.impl;

import nuricanozturk.dev.tv.data.entity.TvShow;
import nuricanozturk.dev.tv.data.repository.ITvShowDetailRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Predicate;

@Repository("nuricanozturk.dev.tv.data.tvShowDetailRepository")
@Lazy
public class TvShowDetailRepository implements ITvShowDetailRepository
{
    @Override
    public long count()
    {
        return 0;
    }

    @Override
    public void delete(TvShow entity)
    {

    }

    @Override
    public void deleteAll()
    {

    }

    @Override
    public void deleteAll(Iterable<? extends TvShow> entities)
    {

    }

    @Override
    public void deleteById(Iterable<? extends Long> ids)
    {

    }

    @Override
    public void deleteById(Long id)
    {

    }

    @Override
    public boolean existById(Long id)
    {
        return false;
    }

    @Override
    public Iterable<TvShow> findAll()
    {
        return null;
    }

    @Override
    public Iterable<TvShow> findAllById(Iterable<Long> id)
    {
        return null;
    }

    @Override
    public Iterable<TvShow> findBy(Predicate<? extends TvShow> pred)
    {
        return null;
    }

    @Override
    public Optional<TvShow> finById(Long id)
    {
        return Optional.empty();
    }

    @Override
    public <S extends TvShow> S save(S entity)
    {
        return null;
    }

    @Override
    public <S extends TvShow> Iterable<S> saveAll(Iterable<S> entities)
    {
        return null;
    }
}
