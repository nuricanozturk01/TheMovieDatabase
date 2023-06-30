drop database if exists tvshowapp;
create database tvshowapp;
USE tvshowapp;
create table tv_show
(
    tvshow_id      int            not null primary key auto_increment,
    real_tvshow_id int            not null,
    name           varchar(80)    not null,
    language       varchar(45)    not null,
    overview       text           not null,
    popularity     decimal(19, 2) not null,
    vote_average   decimal(19, 2) not null,
    vote_count     int            not null
);


create table tv_show_details
(
    tvshow_detail_id int not null primary key auto_increment,
    tvshow_id        int not null,
    episodes_count   int not null,
    season_count     int not null,
    poster_path      varchar(121),
    constraint foreign key (tvshow_id) references tv_show (tvshow_id) on delete cascade on update cascade
);


create table tv_show_genre
(
    genre_pk_id      int not null auto_increment primary key,
    genre_db_id      int not null,
    tvshow_detail_id int not null,
    constraint foreign key (tvshow_detail_id) references tv_show_details (tvshow_detail_id) on update cascade on delete cascade
);

create table tv_show_production_company
(
    company_pk_id    int not null auto_increment primary key,
    company_db_id    int not null,
    tvshow_detail_id int not null,
    constraint foreign key (tvshow_detail_id) references tv_show_details (tvshow_detail_id) on update cascade on delete cascade
);

create table tv_show_production_country
(
    country_pk_id    int not null auto_increment primary key,
    country_db_id    int not null,
    tvshow_detail_id int not null,
    constraint foreign key (tvshow_detail_id) references tv_show_details (tvshow_detail_id) on update cascade on delete cascade
);


create view all_info as
select ts.tvshow_id,
       ts.name,
       ts.language,
       ts.overview,
       ts.popularity,
       ts.vote_average,
       ts.vote_count,
       td.episodes_count,
       td.season_count,
       td.poster_path,
       group_concat(distinct tg.genre_db_id separator ',')     as genres,
       group_concat(distinct tcom.company_db_id separator ',') as companies,
       group_concat(distinct tc.country_db_id separator ',')   as countries
from tv_show as ts
         inner join tv_show_details as td on ts.tvshow_id = td.tvshow_detail_id
         left join tv_show_genre as tg on td.tvshow_detail_id = tg.tvshow_detail_id
         left join tv_show_production_country as tc on td.tvshow_detail_id = tc.tvshow_detail_id
         left join tv_show_production_company as tcom on td.tvshow_detail_id = tcom.tvshow_detail_id
where td.tvshow_detail_id = ts.tvshow_id
group by ts.tvshow_id, ts.name, ts.language, ts.overview, ts.popularity, ts.vote_average, ts.vote_count,
         td.episodes_count, td.season_count, td.poster_path;


DELIMITER $$
create procedure insertTvShow(in realId int, in p_name varchar(80), in p_lng varchar(45), in p_overview text,
                              in p_popularity decimal(19, 2), in p_vote_average decimal(19, 2), in p_vote_count int)
begin
insert into tv_show (real_tvshow_id, name, language, overview, popularity, vote_average, vote_count)
values (realId, p_name, p_lng, p_overview, p_popularity, p_vote_average, p_vote_count);
end $$
DELIMITER ;

DELIMITER $$
create procedure insertTvShowDetail(in p_tvShowId int, in p_episodes int, in p_season int, p_posterPath varchar(121))
begin
insert into tv_show_details(tvshow_id, episodes_count, season_count, poster_path)
values (p_tvShowId, p_episodes, p_season, p_posterPath);
end $$
DELIMITER ;


DELIMITER $$
create procedure insertGenre(in p_dbId int, in p_detailId int)
begin
insert into tv_show_genre(genre_db_id, tvshow_detail_id) values (p_dbId, p_detailId);
end $$
DELIMITER ;

DELIMITER $$
create procedure insertProductionCompany(in p_dbId int, in p_detailId int)
begin
insert into tv_show_production_company(company_db_id, tvshow_detail_id) values (p_dbId, p_detailId);
end $$
DELIMITER ;

DELIMITER $$
create procedure insertProductionCountry(in p_dbId int, in p_detailId int)
begin
insert into tv_show_production_country(country_db_id, tvshow_detail_id) values (p_dbId, p_detailId);
end $$
DELIMITER ;

DELIMITER $$
create procedure removeTvShowById(in p_tvShowId int)
begin
delete from tv_show where tvshow_id = p_tvShowId;
end $$
DELIMITER ;

DELIMITER $$
create procedure showFullTvShowInfo(in p_tvShowId int)
begin
select ts.tvshow_id,
       ts.name,
       ts.language,
       ts.overview,
       ts.popularity,
       ts.vote_average,
       ts.vote_count,
       td.episodes_count,
       td.season_count,
       td.poster_path,
       group_concat(distinct tg.genre_db_id separator ',')     as genres,
       group_concat(distinct tcom.company_db_id separator ',') as companies,
       group_concat(distinct tc.country_db_id separator ',')   as countries
from tv_show as ts
         inner join tv_show_details as td on ts.tvshow_id = td.tvshow_detail_id
         left join tv_show_genre as tg on td.tvshow_detail_id = tg.tvshow_detail_id
         left join tv_show_production_country as tc on td.tvshow_detail_id = tc.tvshow_detail_id
         left join tv_show_production_company as tcom on td.tvshow_detail_id = tcom.tvshow_detail_id
where ts.tvshow_id = p_tvShowId
  and td.tvshow_detail_id = ts.tvshow_id
group by ts.tvshow_id, ts.name, ts.language, ts.overview, ts.popularity, ts.vote_average, ts.vote_count,
         td.episodes_count, td.season_count, td.poster_path;
end $$
DELIMITER ;

DELIMITER $$
create procedure findByGenre(in p_dbID int)
begin
select * from all_info where genres like concat('%', p_dbID, '%');
end;
DELIMITER ;

DELIMITER $$
create procedure findByCompany(in p_dbID int)
begin
select * from all_info where companies like concat('%', p_dbID, '%');
end;
DELIMITER ;

DELIMITER $$
create procedure findByCountry(in p_dbID int)
begin
select * from all_info where countries like concat('%', p_dbID, '%');
end;
DELIMITER ;

DELIMITER $$
create procedure findByVoteAvgBetween(in p_start decimal(19, 2), in p_end decimal(19, 2))
begin
select * from all_info where vote_average between p_start and p_end;
end;
DELIMITER ;

DELIMITER $$
create procedure findById(IN p_id int)
begin
select * from tv_show where tvshow_id = p_id;
end;
DELIMITER ;

DELIMITER $$
create procedure findByRealTvShowId(IN p_id int)
begin
select * from tv_show where real_tvshow_id = p_id;
end;
DELIMITER ;