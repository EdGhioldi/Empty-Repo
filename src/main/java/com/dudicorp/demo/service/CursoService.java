package com.dudicorp.demo.service;

import com.dudicorp.demo.model.Curso;
import com.dudicorp.demo.repository.ICurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CursoService implements ICursoService{

    @Autowired
    private ICurso cursoRepo;

    @Override
    public List<Curso> getCurso(){
        return cursoRepo.findAll();
    }

    @Override
    public void saveCurso(Curso cur) {
        cursoRepo.save(cur);
    }

    @Override
    public void deleteCurso(Long id_cur){
        cursoRepo.deleteById(id_cur);
    }

    @Override
    public Curso findCurso(Long id_curso){
        return cursoRepo.findById(id_curso).orElse(null);
    }

    @Override
    public void editCurso(Long id_curso,
                          String nuevoNombre,
                          String nuevaModalidad,
                          Date nuevaFecha){
        Curso cur = this.findCurso(id_curso);
        cur.setNombre(nuevoNombre);
        cur.setModalidad(nuevaModalidad);
        cur.setFecha_finalizacion(nuevaFecha);
    }

    @Override
    public void editCurso(Curso cur){
        this.saveCurso(cur);
    }
}
