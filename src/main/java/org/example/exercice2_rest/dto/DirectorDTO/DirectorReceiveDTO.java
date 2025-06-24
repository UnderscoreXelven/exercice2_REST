package org.example.exercice2_rest.dto.DirectorDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercice2_rest.entity.Director;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DirectorReceiveDTO {
    private String firstName;
    private String lastName;
    private String birthDate;

    public Director dtoToEntity(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return Director.builder().
                firstName(this.getFirstName())
                .birthDate(LocalDate.parse(this.getBirthDate(), dateTimeFormatter))
                .lastName(this.getLastName())
                .build();
    }
}
