package com.company.internshipProject.Entity.TVSeriesEntity;


import javax.persistence.*;

@Entity
@Table(name = "user_has_tv")
public class UserHasTvShow
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_has_tv_id")
    private int user_has_tv_id;

    @Column(name = "tv_show_id")
    private int tv_show_id;


    @Column(name = "user_id")
    private int user_id;



    public UserHasTvShow() {
    }

    public UserHasTvShow(int tv_show_id, int user_id) {
        this.tv_show_id = tv_show_id;
        this.user_id = user_id;
    }

}
