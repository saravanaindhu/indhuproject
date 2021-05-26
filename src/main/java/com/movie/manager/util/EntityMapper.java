package com.movie.manager.util;

import com.movie.manager.entity.MovieEntity;
import com.movie.manager.entity.MultiplexEntity;
import com.movie.manager.entity.ScreenEntity;
import com.movie.manager.model.Movies;
import com.movie.manager.model.Multiplex;
import com.movie.manager.model.Screen;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class EntityMapper {

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    public MovieEntity mapMovieModelToEntity(Movies movies){
        return dozerBeanMapper.map(movies,MovieEntity.class);
    }

    public List<Movies> mapMovieEntityToModel(List<MovieEntity> movieEntities){
        List<Movies> moviesList = new ArrayList<>();
        for (MovieEntity mov:movieEntities) {
            moviesList.add(dozerBeanMapper.map(mov,Movies.class));
        }
        return moviesList;
    }

    public ScreenEntity mapScreenModelToEntity(Screen screen){
        return dozerBeanMapper.map(screen, ScreenEntity.class);
    }

    public List<Screen> mapScreenEntityToModel(List<ScreenEntity> screenEntityList){
        List<Screen> screensList = new ArrayList<>();
        for (ScreenEntity scr:screenEntityList) {
            screensList.add(dozerBeanMapper.map(scr, Screen.class));
        }
        return screensList;
    }

    public MultiplexEntity mapMultiplexModelToEntity(Multiplex multiplex){
       MultiplexEntity multiplexEntity = new MultiplexEntity();
       Set<ScreenEntity> screensList = new HashSet<>();

        multiplexEntity.setMultiplexId(multiplex.getMultiplexId());
        multiplexEntity.setMultiplexName(multiplex.getMultiplexName());
        multiplexEntity.setAddress(multiplex.getAddress());

        for (Screen scr:multiplex.getScreensList()) {
            ScreenEntity mapDataScreen = new ScreenEntity();
            screensList.add(dozerBeanMapper.map(scr,ScreenEntity.class));
        }
        multiplexEntity.setScreenEntityList(screensList);

        return  multiplexEntity;
    }

    public Multiplex mapMultiplexEntityToModel(MultiplexEntity multiplexEntity){
        Set<Screen> screensSet = new HashSet<>();
        Multiplex multiplex = new Multiplex();
        multiplex.setMultiplexId(multiplexEntity.getMultiplexId());
        multiplex.setMultiplexName(multiplexEntity.getMultiplexName());
        multiplex.setAddress(multiplexEntity.getAddress());
        for (ScreenEntity mscreen:multiplexEntity.getScreenEntityList()) {
            Screen screen = new Screen();
            screensSet.add(dozerBeanMapper.map(mscreen, Screen.class));
        }
        multiplex.setScreensList(screensSet);
        return multiplex;
    }


}
