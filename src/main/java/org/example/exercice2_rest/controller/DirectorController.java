package org.example.exercice2_rest.controller;

import org.example.exercice2_rest.dto.DirectorDTO.DirectorReceiveDTO;
import org.example.exercice2_rest.dto.DirectorDTO.DirectorResponseDTO;
import org.example.exercice2_rest.service.DirectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/catalogue")
public class DirectorController {
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/realisateur")
    public ResponseEntity<List<DirectorResponseDTO>> getRealisateurs(){
        return ResponseEntity.ok(directorService.findAll());
    }

    @GetMapping("/realisateur/{id}")
    public ResponseEntity<DirectorResponseDTO> getRealisateurById(@PathVariable("id") int id){
        return ResponseEntity.ok(directorService.findById(id));
    }

    @PostMapping("/realisateur")
    public ResponseEntity<DirectorResponseDTO> saveRealisateur(@RequestBody DirectorReceiveDTO director){
        return ResponseEntity.status(HttpStatus.CREATED).body(directorService.save(director));
    }
}
