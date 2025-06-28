package com.ud.gestionhotel.Service;

import com.ud.gestionhotel.repository.AdministradorGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorGeneralService {

    private final AdministradorGeneralRepository administradorGeneralRepository;

    @Autowired
    public AdministradorGeneralService(AdministradorGeneralRepository administradorGeneralRepository) {
        this.administradorGeneralRepository = administradorGeneralRepository;
    }
}
