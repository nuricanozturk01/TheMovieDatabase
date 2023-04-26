package nuricanozturk.dev.movie.get.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan("nuricanozturk.dev")
public class MovieGetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieGetServiceApplication.class, args);
	}

}

/*

// Use DBML to define your database structure
// Docs: https://github.com/holistics/dbml/tree/master/dbml-homepage/docs

Table user
{
  user_id integer [primary key]
  username varchar
  password bytes
  movie_id integer
  tv_show_id integer
}

Table movies {
  movie_id integer [primary key]
  language varchar
  title text
  overview text
  popularity float
  release_date date
  vote_average double
  movie_detail_id integer
}

Table movie_details {
  movie_detail_id integer [primary key]
  movie_id integer
  title varchar
  companie_id integer
  country_id integer
  genre_id integer
}

Table countires
{
  country_id integer [primary key]
  country_name varchar
  movie_detail_id integer
  tv_show_id integer
}

Table companies
{
  company_id integer [primary key]
  company_name varchar
  movie_detail_id integer
  tv_show_id integer
}

Table genre
{
  genre_id integer [primary key]
  genre_name varchar
  movie_detail_id integer
  tv_show_id integer
}

Table tv_show {
  tv_show_id integer [primary key]
  language varchar
  title text
  overview text
  popularity float
  release_date date
  vote_average double
  movie_detail_id integer
}

Table tv_show_details {
  tv_show_detail_id integer [primary key]
  tv_show_id integer
  title varchar
  companie_id integer
  country_id integer
  genre_id integer
}

Ref: movie_details.movie_detail_id - movies.movie_id
Ref: movie_details.country_id <> countires.movie_detail_id
Ref: movie_details.companie_id <> companies.movie_detail_id
Ref: movie_details.genre_id <> genre.movie_detail_id



Ref: tv_show_details.tv_show_id - tv_show.tv_show_id
Ref: tv_show_details.country_id <> countires.tv_show_id
Ref: tv_show_details.companie_id <> companies.tv_show_id
Ref: tv_show_details.genre_id <> genre.tv_show_id


Ref: user.movie_id <> movies.movie_id
Ref: user.tv_show_id <> tv_show.tv_show_id



 */