package com.company.internshipProject.Entity.TVSeriesEntity;

import javax.persistence.*;

@Entity
@Table(name = "tv_show")
public class TVShow
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tv_show_id")
    private int id;

    @Column(name = "real_tv_show_id", unique = true)
    private int realTvShowId;

    @Column(name = "title")
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tv_detail_id")
    private TVDetail tvDetails;

    public TVShow() {
    }

    public TVShow(int realTvShowId, String title)
    {
        this.realTvShowId = realTvShowId;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRealTvShowId() {
        return realTvShowId;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public void setTvDetails(TVDetail tvDetails) {
        this.tvDetails = tvDetails;
    }


    @Override
    public String toString() {
        return "TVShow{" +
                "id=" + id +
                ", realTvShowId=" + realTvShowId +
                ", title='" + title + '\'' +
                '}';
    }
}
