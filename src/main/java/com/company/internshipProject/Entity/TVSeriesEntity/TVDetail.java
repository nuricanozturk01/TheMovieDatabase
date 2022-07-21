package com.company.internshipProject.Entity.TVSeriesEntity;

import javax.persistence.*;


@Entity
@Table(name = "tv_details")
public class TVDetail
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tv_detail_id")
    private int id;

    @Column(name = "overview")
    private String overview;

    @Column(name = "season_number")
    private int seasonNumber;

    @Column(name = "episode_number")
    private int episodeNumber;

    @OneToOne(mappedBy = "tvDetails",
    cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH})
    private TVShow tvShow;

    public TVDetail() {
    }

    public TVDetail(String overview, int seasonNumber, int episodeNumber) {
        this.overview = overview;
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
