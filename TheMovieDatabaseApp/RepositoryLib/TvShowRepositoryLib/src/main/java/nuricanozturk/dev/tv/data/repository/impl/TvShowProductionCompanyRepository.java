package nuricanozturk.dev.tv.data.repository.impl;

import nuricanozturk.dev.tv.data.entity.TvShowGenre;
import nuricanozturk.dev.tv.data.entity.TvShowProductionCompany;
import nuricanozturk.dev.tv.data.repository.ITvShowProductionCompanyRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Predicate;

@Repository("nuricanozturk.dev.tv.data.tvShowCompanyRepository")
@Lazy
public class TvShowProductionCompanyRepository implements ITvShowProductionCompanyRepository
{

    @Override
    public long count()
    {
        return 0;
    }

    @Override
    public void delete(TvShowProductionCompany entity)
    {

    }

    @Override
    public void deleteAll()
    {

    }

    @Override
    public void deleteAll(Iterable<? extends TvShowProductionCompany> entities)
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
    public Iterable<TvShowProductionCompany> findAll()
    {
        return null;
    }

    @Override
    public Iterable<TvShowProductionCompany> findAllById(Iterable<Integer> id)
    {
        return null;
    }

    @Override
    public Iterable<TvShowProductionCompany> findBy(Predicate<? extends TvShowProductionCompany> pred)
    {
        return null;
    }

    @Override
    public Optional<TvShowProductionCompany> finById(Integer id)
    {
        return Optional.empty();
    }

    @Override
    public <S extends TvShowProductionCompany> S save(S entity)
    {
        return null;
    }

    @Override
    public <S extends TvShowProductionCompany> Iterable<S> saveAll(Iterable<S> entities)
    {
        return null;
    }
}
