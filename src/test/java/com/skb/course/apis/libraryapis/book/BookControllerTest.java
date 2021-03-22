package com.skb.course.apis.libraryapis.book;

import com.skb.course.apis.libraryapis.AbstractTest;
import com.skb.course.apis.libraryapis.user.User;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

class BookControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    void getBook() throws Exception {

        String uri ="/v1/users/4211";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                /*.accept(MediaType.APPLICATION_JSON)*/).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        User user = super.mapFromJson(content, User.class);
        assertTrue(user.getFirstName().equals("Library"));
    }
}