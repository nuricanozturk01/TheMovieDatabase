package nuricanozturk.dev.tv.data.repository;

public enum TvShowQuery
{
    COUNT_QUERY("select count(*) from tv_show"),
    FIND_ALL_WITH_DETAILS_QUERY("call showFullTvShowInfo(:id)"),
    FIND_BY_GENRE_QUERY("call findByGenre(:name)"),
    FIND_BY_COMPANY_QUERY("call findByCompany(:name)"),
    FIND_BY_COUNTRY_QUERY("call findByCountry(:name)"),
    FIND_BY_VOTE_BETWEEN_QUERY("call findByVoteAvgBetween(:start, :end)"),
    FIND_BY_ID_QUERY("call findById(:id)"),
    FIND_ALL_QUERY("select * from all_info"),
    FIND_BY_REAL_ID_QUERY("call findByRealTvShowId(:id)"),
    SAVE_QUERY("call insertTvShow(:realId, :p_name, :p_lng, :p_overview, :p_popularity, :p_vote_average, :p_vote_count)"),
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
