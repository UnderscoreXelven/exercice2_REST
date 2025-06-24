package org.example.exercice2_rest.dto.MovieDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MovieResponseDTO {
    private int movieId;
    private String titre;
    private String description;
    private long duration;
    private String genre;
    private String releaseDate;
    private int directorId;
}
