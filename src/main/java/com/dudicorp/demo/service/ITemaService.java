package com.dudicorp.demo.service;

import com.dudicorp.demo.model.Tema;

import java.util.List;

public interface ITemaService {
    public List<Tema> getTema();

    public void saveTema(Tema tem);

    public void deleteTema(Long id_tema);

    public Tema findTema(Long id_tema);

    public void editTema(Long id_tema,
                         String nombreNuevo,
                         String descripcionNueva);

    public void editTema(Tema tem);
}
