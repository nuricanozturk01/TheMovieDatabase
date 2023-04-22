package nuricanozturk.dev.tv.data.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tv_show")
public record TvShow(

        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.uuid.UuidGenerator")
        @Column
        long id,

        @Column(name = "title")
        String title)
{

    public TvShow()
    {
        this(0,"");
    }

    public TvShow(long id, String title)
    {
        this.id = id;
        this.title = title;
    }
}
