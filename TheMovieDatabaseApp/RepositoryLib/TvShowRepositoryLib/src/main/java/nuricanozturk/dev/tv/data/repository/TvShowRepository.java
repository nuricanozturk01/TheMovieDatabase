package nuricanozturk.dev.tv.data.repository;

import nuricanozturk.dev.dtolib.db.tvshowdto.DbTvShowWithDetailDTO;
import nuricanozturk.dev.tv.data.entity.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        parameters.registerSqlType("name", Types.VARCHAR);
        parameters.registerSqlType("language", Types.VARCHAR);
        parameters.registerSqlType("overview", Types.VARCHAR);
        parameters.registerSqlType("popularity", Types.DECIMAL);
        parameters.registerSqlType("vote_average", Types.DECIMAL);
        parameters.registerSqlType("vote_count", Types.INTEGER);

        m_jdbcTemplate.update(TvShowQuery.SAVE_TV_SHOW_QUERY.getQuery(), parameters);

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
        var dto = finById(id);
        return dto.isPresent();
    }


    @Override
    public Iterable<DbTvShowWithDetailDTO> findAllWithDetails()
    {
        var tvShows = new ArrayList<DbTvShowWithDetailDTO>();

        m_jdbcTemplate.query(TvShowQuery.FIND_ALL_QUERY.getQuery(), (ResultSet rs) -> fillTvShowList(rs, tvShows));

        return tvShows;
    }

    @Override
    public Iterable<DbTvShowWithDetailDTO> findByGenre(long id)
    {
        var tvShows = new ArrayList<DbTvShowWithDetailDTO>();
        var paramMap = new HashMap<String, Long>();
        paramMap.put("id", id);

        m_jdbcTemplate.query(TvShowQuery.FIND_BY_GENRE_QUERY.getQuery(), paramMap, (ResultSet rs) -> fillTvShowList(rs, tvShows));

        return tvShows;
    }

    @Override
    public Iterable<DbTvShowWithDetailDTO> findByCompany(long id)
    {
        var tvShows = new ArrayList<DbTvShowWithDetailDTO>();
        var paramMap = new HashMap<String, Long>();
        paramMap.put("id", id);

        m_jdbcTemplate.query(TvShowQuery.FIND_BY_COMPANY_QUERY.getQuery(), paramMap, (ResultSet rs) -> fillTvShowList(rs, tvShows));

        return tvShows;
    }

    @Override
    public Iterable<DbTvShowWithDetailDTO> findByCountry(long id)
    {
        var tvShows = new ArrayList<DbTvShowWithDetailDTO>();
        var paramMap = new HashMap<String, Long>();
        paramMap.put("id", id);

        m_jdbcTemplate.query(TvShowQuery.FIND_BY_COUNTRY_QUERY.getQuery(), paramMap, (ResultSet rs) -> fillTvShowList(rs, tvShows));

        return tvShows;
    }

    @Override
    public Iterable<DbTvShowWithDetailDTO> findByVoteAverageBetween(double start, double end)
    {
        var tvShows = new ArrayList<DbTvShowWithDetailDTO>();
        var paramMap = new HashMap<String, Double>();
        paramMap.put("start", start);
        paramMap.put("end", end);

        m_jdbcTemplate.query(TvShowQuery.FIND_BY_VOTE_BETWEEN_QUERY.getQuery(), paramMap, (ResultSet rs) -> fillTvShowList(rs, tvShows));

        return tvShows;
    }

    @Override
    public void saveTvShowDetail(TvShowDetails details)
    {
        var count = count();
        details.setTv_show_detail_id((int) (count + 1));

        var parameters = new BeanPropertySqlParameterSource(details);
        parameters.registerSqlType("tvshow_id", Types.BIGINT);
        parameters.registerSqlType("episodes_count", Types.BIGINT);
        parameters.registerSqlType("season_count", Types.BIGINT);
        parameters.registerSqlType("poster_path", Types.VARCHAR);

        m_jdbcTemplate.update(TvShowQuery.SAVE_TV_SHOW_DETAIL_QUERY.getQuery(), parameters);
    }

    @Override
    public void saveGenre(TvShowGenre genre)
    {
        var count = count();
        genre.setGenre_id((int) (count + 1));

        var parameters = new BeanPropertySqlParameterSource(genre);
        parameters.registerSqlType("p_dbId", Types.BIGINT);
        parameters.registerSqlType("p_detailId", Types.BIGINT);

        m_jdbcTemplate.update(TvShowQuery.SAVE_GENRE_QUERY.getQuery(), parameters);
    }

    @Override
    public void saveCompany(TvShowProductionCompany company)
    {
        var count = count();
        company.setCompany_id((int) (count + 1));

        var parameters = new BeanPropertySqlParameterSource(company);
        parameters.registerSqlType("p_dbId", Types.BIGINT);
        parameters.registerSqlType("p_detailId", Types.BIGINT);

        m_jdbcTemplate.update(TvShowQuery.SAVE_COMPANY_QUERY.getQuery(), parameters);
    }

    @Override
    public void saveCountry(TvShowProductionCountry country)
    {
        var count = count();
        country.setCountry_id((int) (count + 1));

        var parameters = new BeanPropertySqlParameterSource(country);
        parameters.registerSqlType("p_dbId", Types.BIGINT);
        parameters.registerSqlType("p_detailId", Types.BIGINT);

        m_jdbcTemplate.update(TvShowQuery.SAVE_COUNTRY_QUERY.getQuery(), parameters);
    }

    @Override
    public void deleteById(Long id)
    {
        var parameters = new HashMap<String, Long>();
        parameters.put("id", id);
        m_jdbcTemplate.update(TvShowQuery.REMOVE_QUERY.getQuery(), parameters);
    }

    @Override
    public Iterable<DbTvShowWithDetailDTO> findWithDetails(long id)
    {
        var tvShows = new ArrayList<DbTvShowWithDetailDTO>();
        var paramMap = new HashMap<String, Long>();
        paramMap.put("id", id);

        m_jdbcTemplate.query(TvShowQuery.FIND_ALL_WITH_DETAILS_QUERY.getQuery(), paramMap, (ResultSet rs) -> fillTvShowList(rs, tvShows));

        return tvShows;
    }

    private void fillTvShowList(ResultSet rs, ArrayList<DbTvShowWithDetailDTO> tvShows) throws SQLException
    {
        do
            tvShows.add(getTvShow(rs));
        while (rs.next());
    }

    private DbTvShowWithDetailDTO getTvShow(ResultSet rs) throws SQLException
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

        return new DbTvShowWithDetailDTO(id, name, language, overview, posterPath, genres, companies, countries,
                popularity, voteAverage, voteCount, episodesCount, seasonCount);
    }

    @Override
    public Optional<TvShow> finById(Long id)
    {
        var list = new ArrayList<TvShow>();
        var paramMap = new HashMap<String, Long>();
        paramMap.put("id", id);
        m_jdbcTemplate.query(TvShowQuery.FIND_BY_ID_QUERY.getQuery(), paramMap, (ResultSet rs) -> fillTvShowList(rs, list));
        return Optional.of(list.get(0));
    }

    private void fillTvShowList(ResultSet rs, List<TvShow> list) throws SQLException
    {
        do {
            var id = rs.getInt(1);
            var real_id = rs.getInt(2);
            var name = rs.getString(3);
            var language = rs.getString(4);
            var overview = rs.getString(5);
            var popularity = rs.getDouble(6);
            var voteAverage = rs.getDouble(7);
            var voteCount = rs.getInt(8);

            list.add(new TvShow(id, real_id, name, language, overview, popularity, voteAverage, voteCount));

        } while (rs.next());
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
    public Iterable<TvShow> findAll()
    {
        throw new UnsupportedOperationException("NOT SUPPORTED!");
    }

    @Override
    public <S extends TvShow> Iterable<S> saveAll(Iterable<S> entities)
    {
        throw new UnsupportedOperationException("NOT SUPPORTED!");
    }
}
