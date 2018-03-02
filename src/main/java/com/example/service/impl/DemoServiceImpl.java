package com.example.service.impl;

import com.example.exception.BusinessException;
import com.example.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService{
    @Override
    public void demoMethod1() {
        if(1==1){
            throw new BusinessException("业务异常！",111);
        }
    }
}
