package org.example.exercice2_rest.service;

import org.example.exercice2_rest.dto.MovieDTO.MovieReceiveDTO;
import org.example.exercice2_rest.dto.MovieDTO.MovieResponseDTO;
import org.example.exercice2_rest.entity.Movie;
import org.example.exercice2_rest.exception.NotFoundException;
import org.example.exercice2_rest.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieResponseDTO save(MovieReceiveDTO movie){
        return movieRepository.save(movie.dtoToEntity()).dtoToEntity();
    }

    public MovieResponseDTO findById(int id){
        return movieRepository.findById(id).orElseThrow(NotFoundException::new).dtoToEntity();
    }

    public void deleteById(int id){
        movieRepository.deleteById(id);
    }

    public List<MovieResponseDTO> findAll(){
        return movieRepository.findAll().stream().map(Movie::dtoToEntity).toList();
    }
}
