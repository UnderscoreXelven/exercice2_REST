package org.example.exercice2_rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercice2_rest.dto.DirectorDTO.DirectorResponseDTO;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int directorId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @OneToMany(mappedBy = "director")
    private List<Movie> movies;

    public DirectorResponseDTO entityToDto(){
        return DirectorResponseDTO.builder()
                .directorId(this.getDirectorId())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .birthDate(this.getBirthDate().toString())
                .build();
    }
}
