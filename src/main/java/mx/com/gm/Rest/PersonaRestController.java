/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.Rest;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author frank
 */
@Slf4j
@RestController
@RequestMapping("/personas")
public class PersonaRestController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> listar() {
        log.info("se ejecuto el service listarPersonas en el REST CONTROLLER");
        return personaService.listarPersonas();
    }

    @PostMapping
    public void insertar(@RequestBody Persona persona) {
        log.info("se ejecuto el service GUARDAR en el REST CONTROLLER");
        personaService.guardar(persona);
    }

}
