package com.example.service.impl;

import com.example.exception.BusinessException;
import com.example.po.Actor;
import com.example.repository.ActorRepository;
import com.example.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
    private ActorRepository actorRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public Actor save(Actor actor) {
        String idcard = actor.getIdcard();
        Actor rt_actor = actorRepository.findByIdcard(idcard);
        if(null != rt_actor){
            throw new BusinessException("the Actor[idcard:"+idcard+"] has exists,could not save again!");
        }
        return actorRepository.save(actor);
    }

    @Override
    public Actor get(int actorid) {
        Actor actor = actorRepository.findByActorid(actorid);
        if(null == actor){
            throw new BusinessException("the actor with id ["+actorid+"] can not found!",null);
        }
        return actor;
    }

    @Override
    public List<Actor> findAllByFirstname(String firstname) {
        return actorRepository.findAllByFirstname(firstname);
    }
}
