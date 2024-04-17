package com.dudicorp.demo.controller;

import com.dudicorp.demo.model.Tema;
import com.dudicorp.demo.service.ITemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TemaController {
    @Autowired
    private ITemaService temaServ;

    @GetMapping("/listar/tema")
    public List<Tema> getTema(){
        return temaServ.getTema();
    }


    @PostMapping("/nuevoTema")
    public String saveTema(@RequestBody Tema tem){
        temaServ.saveTema(tem);
        return "Nuevo TEMA creado con éxito";
    }

    @PutMapping("/editar/tema/{id_tema}")
    public Tema editTema(@PathVariable Long id_tema,
                    @RequestParam(required=false, name= "nombre" )String nombreNuevo,
                    @RequestParam(required=false, name = "descripcion") String descripcionNueva){
        return temaServ.findTema(id_tema);
    }

    @PutMapping("/editar/tema")
    public Tema editTema(@RequestBody Tema tem){
        temaServ.editTema(tem);
        return temaServ.findTema(tem.getId_tema());
    }

    @DeleteMapping("/eliminar/tema/{id}")
    public String deleteTema(@PathVariable Long id_tema){
        temaServ.deleteTema(id_tema);
        return "Se eliminó el TEMA seleccionado";
    }
}

