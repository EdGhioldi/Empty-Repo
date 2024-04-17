package com.dudicorp.demo.service;

import com.dudicorp.demo.model.Tema;
import com.dudicorp.demo.repository.ITema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TemaService implements ITemaService{

    @Autowired
    private ITema temaRepo;

    @Override
    public List<Tema> getTema(){
        return temaRepo.findAll();
    }

    @Override
    public void saveTema(Tema tem){
        temaRepo.save(tem);
    }

    @Override
    public void deleteTema(Long id_tema){
        temaRepo.deleteById(id_tema);
    }

    @Override
    public Tema findTema(Long id_tema){
        return temaRepo.findById(id_tema).orElse(null);
    }

    @Override
    public void editTema(Long id_tema, String nombreNuevo, String descripcionNueva){
        Tema tem = this.findTema(id_tema);
        tem.setNombre(nombreNuevo);
        tem.setDescripcion(descripcionNueva);
    }

    @Override
    public void editTema(Tema tem){
        this.saveTema(tem);
    }
}
