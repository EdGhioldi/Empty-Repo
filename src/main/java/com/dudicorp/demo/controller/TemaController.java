package com.dudicorp.demo.controller;

import com.dudicorp.demo.model.Tema;
import com.dudicorp.demo.service.ITemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class TemaController {

    @Autowired
    private ITemaService temaServ;

    //2-Crear un nuevo tema
    @PostMapping ("/temas/crear")
    public String crearCurso(@RequestBody Tema tema) {
        temaServ.saveTema(tema);

        return "Tema creado correctamente";

    }

    //7-Modificar los datos de un determinado tema
    @PutMapping("/tema/edit")
    public String editTema(@RequestBody Tema tema) {
        temaServ.editTema(tema);
        return "Tema editado correctamente";
    }

}
