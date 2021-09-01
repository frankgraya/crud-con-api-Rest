package mx.com.gm.servicio;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        log.info("se ejecuto el service listarPersonas");
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        log.info("se ejecuto el service guardar");
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        log.info("se ejecuto el service eliminar");
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        log.info("se ejecuto el service Editar");
          log.info("Mantenimiento revisar por que aun no edita");
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }

}
