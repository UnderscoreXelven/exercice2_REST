package org.example.exercice2_rest.service;

import org.example.exercice2_rest.dto.DirectorDTO.DirectorReceiveDTO;
import org.example.exercice2_rest.dto.DirectorDTO.DirectorResponseDTO;
import org.example.exercice2_rest.entity.Director;
import org.example.exercice2_rest.exception.NotFoundException;
import org.example.exercice2_rest.repository.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    private DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public DirectorResponseDTO save(DirectorReceiveDTO director){
        return directorRepository.save(director.dtoToEntity()).entityToDto();
    }

    public DirectorResponseDTO findById(int id){
        return directorRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public void deleteById(int id){
        directorRepository.deleteById(id);
    }

    public List<DirectorResponseDTO> findAll(){
        return directorRepository.findAll().stream().map(Director::entityToDto).toList();
    }
}
