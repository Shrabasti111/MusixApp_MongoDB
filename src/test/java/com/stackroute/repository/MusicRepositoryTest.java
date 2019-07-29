package com.stackroute.repository;


import com.stackroute.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MusicRepositoryTest {

    @Autowired
    MusicRepository musicRepository;
    Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setId(2);
        track.setName("John");
        track.setComments("asdcsd");

    }

    @After
    public void tearDown(){

        musicRepository.deleteAll();
    }


    @Test
    public void testSaveUser(){
        musicRepository.save(track);
        Track fetchUser = musicRepository.findById(track.getId()).get();
        Assert.assertEquals(2,fetchUser.getId());

    }



}
