package nuricanozturk.dev.tv.data.repository.query;

import org.springframework.stereotype.Component;


public enum TvShowQuery
{
    COUNT_QUERY("select count(*) from tv_show"),
    FIND_ALL_WITH_DETAILS_QUERY("call showFullTvShowInfo(:id)"),
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
