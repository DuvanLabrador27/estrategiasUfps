package com.ayd.aulas.service.clase.impl;

import com.ayd.aulas.dao.ClaseEstrategiaDao;
import com.ayd.aulas.service.clase.AsignarEstrategiaClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignarEsttrategiaClaseServiceImpl implements AsignarEstrategiaClaseService {

    @Autowired
    private ClaseEstrategiaDao claseEstrategiaDao;
    @Override
    public void ejecutar() {

    }
}
