package nuricanozturk.dev.movie.data.config;

import nuricanozturk.dev.movie.data.repository.*;
import org.springframework.stereotype.Component;

@Component
public class MoviesDBRepoConfig
{
    public final IMovieRepository m_movieRepository;
    public final IMovieDetailsRepository m_movieDetailsRepository;
    public final IMovieProductionCompanyRepository m_movieProductionCompanyRepository;
    public final IMovieProductionCountryRepository m_movieProductionCountryRepository;
    public final IMovieGenresRepository m_movieGenresRepository;

    public MoviesDBRepoConfig(IMovieRepository movieRepository, IMovieDetailsRepository movieDetailsRepository,
                              IMovieProductionCompanyRepository movieProductionCompanyRepository,
                              IMovieProductionCountryRepository movieProductionCountryRepository,
                              IMovieGenresRepository movieGenresRepository)
    {
        m_movieRepository = movieRepository;
        m_movieDetailsRepository = movieDetailsRepository;
        m_movieProductionCompanyRepository = movieProductionCompanyRepository;
        m_movieProductionCountryRepository = movieProductionCountryRepository;
        m_movieGenresRepository = movieGenresRepository;
    }


}
