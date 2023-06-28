package nuricanozturk.dev.dtolib.entity.api.tv;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CreatedBy{
    @JsonIgnore
    public int id;
    @JsonIgnore
    public String credit_id;
    public String name;
    @JsonIgnore
    public int gender;
    @JsonIgnore
    public Object profile_path;
}