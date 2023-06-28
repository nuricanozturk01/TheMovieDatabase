package nuricanozturk.dev.tv.data.repository.impl;

import nuricanozturk.dev.dtolib.db.tvshowdto.DbTvShowWithDetailsDTO;
import nuricanozturk.dev.tv.data.entity.TvShow;
import nuricanozturk.dev.tv.data.repository.ITvShowRepository;
import nuricanozturk.dev.tv.data.repository.query.TvShowQuery;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Predicate;

@Repository("nuricanozturk.dev.tv.data.tvShowRepository")
@Lazy
public class TvShowRepository implements ITvShowRepository
{
    private final NamedParameterJdbcTemplate m_jdbcTemplate;

    public TvShowRepository(NamedParameterJdbcTemplate jdbcTemplate)
    {
        m_jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long count()
    {
        var counts = new ArrayList<Long>();
        m_jdbcTemplate.query(TvShowQuery.COUNT_QUERY.getQuery(), rs -> {
            counts.add(rs.getLong(1));
        });
        return counts.get(0);
    }

    @Override
    public <S extends TvShow> S save(S entity)
    {
        var count = count();
        entity.setTv_show_id(count + 1);

        var parameters = new BeanPropertySqlParameterSource(entity);
        parameters.registerSqlType("realId", Types.BIGINT);
        parameters.registerSqlType("p_name", Types.VARCHAR);
        parameters.registerSqlType("p_lng", Types.VARCHAR);
        parameters.registerSqlType("p_overview", Types.VARCHAR);
        parameters.registerSqlType("p_popularity", Types.DECIMAL);
        parameters.registerSqlType("p_vote_average", Types.DECIMAL);
        parameters.registerSqlType("p_vote_count", Types.INTEGER);

        m_jdbcTemplate.update(TvShowQuery.SAVE_QUERY.getQuery(), parameters);

        return entity;
    }

    @Override
    public void delete(TvShow entity)
    {
        deleteById(entity.getTv_show_id());
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
    public void deleteById(Long id)
    {
        var parameters = new HashMap<String, Long>();
        parameters.put("id", id);
        m_jdbcTemplate.update(TvShowQuery.REMOVE_QUERY.getQuery(), parameters);
    }

    @Override
    public Iterable<DbTvShowWithDetailsDTO> findAllWithDetails(long id)
    {
        var tvShows = new ArrayList<DbTvShowWithDetailsDTO>();
        var paramMap = new HashMap<String, Long>();
        paramMap.put("id", id);

        m_jdbcTemplate.query(TvShowQuery.FIND_ALL_WITH_DETAILS_QUERY.getQuery(), paramMap, (ResultSet rs) -> fillTvShowList(rs, tvShows));

        return tvShows;
    }

    private void fillTvShowList(ResultSet rs, ArrayList<DbTvShowWithDetailsDTO> tvShows) throws SQLException
    {
        do
            tvShows.add(getTvShow(rs));
        while (rs.next());
    }

    private DbTvShowWithDetailsDTO getTvShow(ResultSet rs) throws SQLException
    {
        var id = rs.getInt(1);
        var name = rs.getString(2);
        var language = rs.getString(3);
        var overview = rs.getString(4);
        var popularity = rs.getDouble(5);
        var voteAverage = rs.getDouble(6);
        var voteCount = rs.getInt(7);
        var episodesCount = rs.getInt(8);
        var seasonCount = rs.getInt(9);
        var posterPath = rs.getString(10);
        var genres = rs.getString(11);
        var companies = rs.getString(12);
        var countries = rs.getString(13);

        return new DbTvShowWithDetailsDTO(id, name, language, overview, posterPath, genres, companies, countries,
                popularity, voteAverage, voteCount, episodesCount, seasonCount);
    }

    @Override
    public Optional<TvShow> finById(Long id)
    {
        return Optional.empty();
    }


    //-----------------------------------------------------------------------------------------------------------------
    @Override
    public void deleteAll()
    {
        throw new UnsupportedOperationException("NOT SUPPORTED!");
    }

    @Override
    public void deleteAll(Iterable<? extends TvShow> entities)
    {
        throw new UnsupportedOperationException("NOT SUPPORTED!");
    }

    @Override
    public void deleteById(Iterable<? extends Long> ids)
    {
        throw new UnsupportedOperationException("NOT SUPPORTED!");
    }

    @Override
    public Iterable<TvShow> findAllById(Iterable<Long> id)
    {
        throw new UnsupportedOperationException("NOT SUPPORTED!");
    }

    @Override
    public Iterable<TvShow> findBy(Predicate<? extends TvShow> pred)
    {
        throw new UnsupportedOperationException("NOT SUPPORTED!");
    }


    @Override
    public <S extends TvShow> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException("NOT SUPPORTED!");
    }


}
