package org.example.exercice2_rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercice2_rest.dto.MovieDTO.MovieResponseDTO;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String titre;
    private LocalDate releaseDate;
    private String description;
    private long duration;
    private String genre;
    @ManyToOne
    @JoinColumn(name = "directorId")
    private Director director;

    public MovieResponseDTO dtoToEntity(){
        return MovieResponseDTO.builder()
                .movieId(this.getMovieId())
                .titre(this.getTitre())
                .releaseDate(this.getReleaseDate().toString())
                .description(this.getDescription())
                .duration(this.getDuration())
                .genre(this.getGenre())
                .directorId(this.getDirector().getDirectorId())
                .build();
    }
}
