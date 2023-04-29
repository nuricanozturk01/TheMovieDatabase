package nuricanozturk.dev.movie.save.dto;

public class ExistsDTO
{
    public boolean exists;
    public boolean added;


    public ExistsDTO(boolean exists, boolean added)
    {
        this.exists = exists;
        this.added = added;
    }
}
