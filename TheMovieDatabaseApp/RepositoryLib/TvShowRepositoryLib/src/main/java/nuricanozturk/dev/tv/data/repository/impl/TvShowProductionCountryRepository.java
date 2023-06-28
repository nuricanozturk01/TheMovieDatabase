package nuricanozturk.dev.tv.data.repository.impl;

import nuricanozturk.dev.tv.data.entity.TvShowGenre;
import nuricanozturk.dev.tv.data.entity.TvShowProductionCountry;
import nuricanozturk.dev.tv.data.repository.ITvShowProductionCountryRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Predicate;

@Repository("nuricanozturk.dev.tv.data.tvShowCountryRepository")
@Lazy
public class TvShowProductionCountryRepository implements ITvShowProductionCountryRepository
{


    @Override
    public long count()
    {
        return 0;
    }

    @Override
    public void delete(TvShowProductionCountry entity)
    {

    }

    @Override
    public void deleteAll()
    {

    }

    @Override
    public void deleteAll(Iterable<? extends TvShowProductionCountry> entities)
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
    public Iterable<TvShowProductionCountry> findAll()
    {
        return null;
    }

    @Override
    public Iterable<TvShowProductionCountry> findAllById(Iterable<Integer> id)
    {
        return null;
    }

    @Override
    public Iterable<TvShowProductionCountry> findBy(Predicate<? extends TvShowProductionCountry> pred)
    {
        return null;
    }

    @Override
    public Optional<TvShowProductionCountry> finById(Integer id)
    {
        return Optional.empty();
    }

    @Override
    public <S extends TvShowProductionCountry> S save(S entity)
    {
        return null;
    }

    @Override
    public <S extends TvShowProductionCountry> Iterable<S> saveAll(Iterable<S> entities)
    {
        return null;
    }
}
