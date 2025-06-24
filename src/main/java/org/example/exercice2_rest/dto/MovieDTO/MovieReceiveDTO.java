package org.example.exercice2_rest.dto.MovieDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercice2_rest.entity.Director;
import org.example.exercice2_rest.entity.Movie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MovieReceiveDTO {
    private String titre;
    private String description;
    private long duration;
    private String genre;
    private String releaseDate;
    private Director director;

    public Movie dtoToEntity(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return Movie.builder()
                .titre(this.getTitre())
                .description(this.getDescription())
                .duration(this.getDuration())
                .genre(this.getGenre())
                .director(this.getDirector())
                .releaseDate(LocalDate.parse(this.getReleaseDate(), dateTimeFormatter))
                .build();
    }
}
