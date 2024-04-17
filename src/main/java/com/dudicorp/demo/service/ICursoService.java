package com.dudicorp.demo.service;

import com.dudicorp.demo.model.Curso;
import java.util.Date;
import java.util.List;

public interface ICursoService {
    public List<Curso> getCurso();
    public void saveCurso(Curso curso);

    public void deleteCurso(Long id_cur);

    public Curso findCurso(Long id_curso);

    public void editCurso(Long id_curso,
                          String nuevoNombre,
                          String nuevaModalidad,
                          Date nuevaFecha);
    public void editCurso(Curso cur);
}
