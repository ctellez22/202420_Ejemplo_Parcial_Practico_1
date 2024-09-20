package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialprueba.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialprueba.repositories.MedicoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    @Transactional
    public MedicoEntity createMedico(MedicoEntity medico) {
        log.info("Inicia proceso de creación del médico");

        // Validación del registro médico
        if (!medico.getRegistroMedico().startsWith("RM")) {
            throw new IllegalArgumentException("El registro médico debe iniciar con 'RM'.");
        }

        return medicoRepository.save(medico);
    }
}
