package org.example.exercice2_rest.dto.DirectorDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercice2_rest.dto.MovieDTO.MovieResponseDTO;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DirectorResponseDTO {
    private int directorId;
    private String firstName;
    private String lastName;
    private String birthDate;
    private List<Integer> movies;
}
