package org.hibernate.tutorial.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by fossufil on 01.12.2014.
 */
//@Table(name = "tbl_event")
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

//    @Column()
    private String title;

//    @Column()
    private int children;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Event() {}

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int foo(){
        return 1;
    }

}
