package nuricanozturk.dev.tv.data.repository;

public enum TvShowQuery
{
    COUNT_QUERY("select count(*) from tv_show"),
    FIND_ALL_WITH_DETAILS_QUERY("call showFullTvShowInfo(:id)"),
    FIND_BY_GENRE_QUERY("call findByGenre(:id)"),
    FIND_BY_COMPANY_QUERY("call findByCompany(:id)"),
    FIND_BY_COUNTRY_QUERY("call findByCountry(:id)"),
    FIND_BY_VOTE_BETWEEN_QUERY("call findByVoteAvgBetween(:start, :end)"),
    FIND_BY_ID_QUERY("call findById(:id)"),
    FIND_ALL_QUERY("select * from all_info"),
    FIND_BY_REAL_ID_QUERY("call findByRealTvShowId(:id)"),
    SAVE_TV_SHOW_QUERY("call insertTvShow(:realId, :name, :language, :overview, :popularity, :vote_average, :vote_count)"),
    SAVE_TV_SHOW_DETAIL_QUERY("call insertTvShowDetail(:tvshow_id, :episodes_count, :season_count, :poster_path)"),
    SAVE_GENRE_QUERY("call insertGenre(:p_dbId, :p_detailId)"),
    SAVE_COMPANY_QUERY("call insertProductionCompany(:p_dbId, :p_detailId)"),
    SAVE_COUNTRY_QUERY("call insertProductionCountry(:p_dbId, :p_detailId)"),
    REMOVE_QUERY("call removeTvShowById(:id)");

    private final String m_query;

    TvShowQuery(String query)
    {
        m_query = query;
    }

    public String getQuery()
    {
        return m_query;
    }
}
