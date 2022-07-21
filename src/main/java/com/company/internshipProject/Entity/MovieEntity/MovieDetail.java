package com.company.internshipProject.Entity.MovieEntity;

import javax.persistence.*;

@Entity
@Table(name = "movie_details")
public class MovieDetail
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private int detailId;

    @Column(name = "overview")
    private String overview;

    @Column(name = "genre")
    private String genre;

    @Column(name = "production")
    private String production;

    @OneToOne(mappedBy="movieDetails", // clas name
            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
                    CascadeType.REFRESH}) // wtihiout CASCADE DELETE
    private Movie movie;

    public MovieDetail()
    {

    }
    public MovieDetail(String overview, String genre, String production)
    {
        this.overview = overview;
        this.genre = genre;
        this.production = production;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getGenre() {
        return genre;
    }

    public String getProduction() {
        return production;
    }




}
