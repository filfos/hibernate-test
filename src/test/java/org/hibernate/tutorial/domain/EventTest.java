package org.hibernate.tutorial.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EventTest  {


    @Test
    public void fooTest(){
        Event e = new Event();
        assertThat(e.foo(), is(1));
    }

}