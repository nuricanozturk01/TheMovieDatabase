# Attention

    - This project is rewriting...
    - You can see the old version on old_version folder until new version finished
# Notes
    - I will add unit tests and exception handling

## Completed Parts:
    - Services
        1- Movie Services
            - MovieGetTMDBService
            - MovieGetDBService
            - MoviePostService [include delete]
        2- TvShow Services
            - TvShowGetTMDBService
            - TvShowGetDBService
            - TvShowPostService [include delete]
        3- Generic Service (for genre, production companies and production countries)
        
    - Libraries
        1 - RepositoryLib
            - MovieRepositoryLib   [PostgreSQL - ORM]
            - TvShowRepositoryLib  [MySQL - JDBC]
            - GenericRepository    [MySQL - ORM]
        2 - DTO Lib   
        
## Incomplete Parts:
    - Services
        1 - UserService  [include security]
    - Libraries
        1- UserRepositoryLib [MongoDB - ORM]

## Planing Parts:
    - Scheduler Services: 
        - Send email to user specific range
        - Backup Databases    
    
## Development Diagram [Updated]

![Updated drawio](https://github.com/nuricanozturk01/TheMovieDatabase/assets/62218588/85f1c888-9f82-4283-ace6-197cab8afcc5)


