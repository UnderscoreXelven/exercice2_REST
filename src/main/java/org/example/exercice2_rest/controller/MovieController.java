package org.example.exercice2_rest.controller;

import org.example.exercice2_rest.dto.MovieDTO.MovieReceiveDTO;
import org.example.exercice2_rest.dto.MovieDTO.MovieResponseDTO;
import org.example.exercice2_rest.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/catalogue")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/films")
    public ResponseEntity<List<MovieResponseDTO>> getFilms(){
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/film/{id}")
    public ResponseEntity<MovieResponseDTO> getFilmById(@PathVariable("id") int id){
        return ResponseEntity.ok(movieService.findById(id));
    }

    @PostMapping("/film")
    public ResponseEntity<MovieResponseDTO> saveMovie(@RequestBody MovieReceiveDTO movieReceiveDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.save(movieReceiveDTO));
    }
}
