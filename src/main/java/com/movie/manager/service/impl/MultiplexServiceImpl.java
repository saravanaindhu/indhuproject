package com.movie.manager.service.impl;

import com.movie.manager.entity.MultiplexEntity;
import com.movie.manager.entity.ScreenEntity;
import com.movie.manager.model.Multiplex;
import com.movie.manager.model.Screen;
import com.movie.manager.repository.MultiPlexRepository;
import com.movie.manager.repository.ScreenRepository;
import com.movie.manager.service.IMultiplexService;
import com.movie.manager.util.EntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultiplexServiceImpl implements IMultiplexService {

    private static final Logger log = LoggerFactory.getLogger(MultiplexServiceImpl.class);

    @Autowired
    ScreenRepository screenRepository;

    @Autowired
    MultiPlexRepository multiPlexRepository;

    @Autowired
    private EntityMapper entityMapper;


    public List<Screen> getAllScreens(){
        List<ScreenEntity> screenEntityList = this.screenRepository.findAll();
        return entityMapper.mapScreenEntityToModel(screenEntityList);
    }

    public Multiplex getMultiplexById(Integer multiplexId){
        MultiplexEntity multiplexEntity =  multiPlexRepository.findByMultiplexId(multiplexId);
        return entityMapper.mapMultiplexEntityToModel(multiplexEntity);
    }

    public void saveMutliplex(Multiplex multiplex){
        this.multiPlexRepository.save(entityMapper.mapMultiplexModelToEntity(multiplex));
        log.info("Multiplex added successfully{}",multiplex.getMultiplexName());
    }

    public void saveScreen(Screen screen){
        this.screenRepository.save(entityMapper.mapScreenModelToEntity(screen));
        log.info("Screen added successfully{}",screen.getScreenNumber());
    }

}
