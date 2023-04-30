package nuricanozturk.dev.dtolib.db.genericdtos;


public class GenreDTO
{
    private long genre_id;

    private String name;


    public GenreDTO()
    {
    }

    public GenreDTO(String name, long genre_id)
    {
        this.name = name;
        this.genre_id = genre_id;
    }

    public GenreDTO(String name)
    {
        this.name = name;
    }

    public long getGenre_id()
    {
        return genre_id;
    }

    public void setGenre_id(long genre_id)
    {
        this.genre_id = genre_id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
