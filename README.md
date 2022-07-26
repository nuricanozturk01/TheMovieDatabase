# TheMovieDatabaseDemo
 tmdb java spring backend
 
 # Spring Boot, Hibernate, JWT, Rest API

### Auth
| Method | URL                  | Description       | Link                    |
|--------|----------------------|-------------------|-------------------------|
| POST   | /auth/login          | Login             | [JSON](#login)          |
| POST   | /auth/add            | Sign Up           | [JSON](#signup)         |
| POST   | /auth/changePassword | Change Password   | [JSON](#changePassword) |


### Movie
| Method | URL                      | Description                 | Link                        |
|--------|--------------------------|-----------------------------|-----------------------------|
| GET    | /movies/getAllMovies     | Get movies in page          | [JSON](#getAllMovies)       |
| GET    | /movies/getPopularMovies | Get popular movies in page  | [JSON](#getPopularMovies)   |
| GET    | /movies/getMovie         | Get detail of movie with id | [JSON](#getMovieDetail)     |
| GET    | /movies/search           | Search Movie with title     | [JSON](#searchMovie)        |

### TV
| Method | URL                    | Description               | Link                        |
|--------|------------------------|---------------------------|-----------------------------|
| GET    | /tv/getTvDetail        | Get tv detail with page   | [JSON](#getTvDetail)        |
| GET    | /tv/getTvSeries        | Get tv series with page   | [JSON](#getTvSeries)        |
| GET    | /tv/getPopularTvSeries | Get tv detail with id     | [JSON](#getPopularTvSeries) |
| GET    | /tv/searchTvShow       | Search tv show with title | [JSON](#searchTvShow)       |

### User
| Method | URL                            | Description                    | Link                              |
|--------|--------------------------------|--------------------------------|-----------------------------------|
| POST   | /user/movie/addFavouriteList   | Add favourite movie to db      | [JSON](#addMovieToFavouriteList)  |
| GET    | /user/movie/getFavouriteMovies | Get user's favourite movies    | [JSON](#getFavouriteMovies)       |
| POST   | /user/movie/delete             | Delete movie with id           | [JSON](#deleteMovie)              |
| POST   | /user/tv/addFavouriteList      | Add favourite tv series to db  | [JSON](#addTvShowToFavouriteList) |
| GET    | /user/tv/getFavouriteTvSeries  | Get user's favourite tv series | [JSON](#getFavouriteTvShows)      |

## Sample JSON Requests

##### <a id="login"> Login -> auth/login
```json
{
	"username": "can",
	"password": "can123",
	"email" : "can@gmail.com"
}
```
##### <a id="signup"> Login -> auth/add
```json
{
	"username": "can",
	"password": "can123",
	"email" : "can@gmail.com"
}
```
##### <a id="changePassword"> Change Password -> /login/changePassword
```json
{
	"username": "can",
	"email" : "can@gmail.com"
}
```

##### <a id="getAllMovies"> Get Movies Page by Page -> /movies/getAllMovies (Request param is "page")
```http request
    http://localhost:8080/movies/getAllMovies?page=21
```

##### <a id="getPopularMovies"> Get Popular Movies Page by Page -> /movies/getPopularMovies (Request param is "page")
```http request
    http://localhost:8080/movies/getPopularMovies?page=79
```


##### <a id="getMovieDetail"> Get Detail of Movie -> /movies/getMovie (Request param is "page")
```http request
    http://localhost:8080/movies/getMovie?id=69
```


##### <a id="searchMovie"> Search Movie with Title -> /movies/search
```json
{
	"title": "thor"
}
```

##### <a id="getTvDetail"> Get Detail of Tv Show -> /tv/getTvDetail (Request param is "id")
```http request
    http://localhost:8080/tv/getTvDetail?id=63
```

##### <a id="getTvSeries"> Get Tv Series Page by Page -> /tv/getTvSeries (Request param is "id")
```http request
    http://localhost:8080/tv/getPopularTvSeries?id=234
```

	

##### <a id="getPopularTvSeries"> Get Popular Tv Series Page by Page -> /tv/getPopularTvSeries (Request param is "page")
```http request
    http://localhost:8080/tv/getPopularTvSeries?page=358
```

##### <a id="searchTvShow"> Search Tv Series with Title -> /tv/searchTvShow
```json
{
	"title": "breaking bad"
}
```
##### <a id="addMovieToFavouriteList"> Add Movie to Favourite List -> /users/addFavouriteList (Request param is "id")
```http request
    http://localhost:8080/user/movie/addFavouriteList?id=536
```


##### <a id="getFavouriteMovies"> Get favourite Movies (current user) -> /user/movie/getFavouriteList 
```http request
    http://localhost:8080/user/movie/getFavouriteList
```


##### <a id="deleteMovie"> Delete movie from favourite list -> /users/movie/delete (Request param is "id")
```http request
    http://localhost:8080/user/movie/delete?id=3
```


##### <a id="addTvShowToFavouriteList"> Add Tv Show to Favourite List -> /user/tv/addFavouriteList (Request param is "id")
```http request
    http://localhost:8080/user/tv/addFavouriteList?id=724
```
##### <a id="getFavouriteTvShows"> Get favourite Tv Series (current user) -> /user/tv/getFavouriteList
```http request
    http://localhost:8080/user/tv/getFavouriteList
```
