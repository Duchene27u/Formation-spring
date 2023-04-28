package fr.sparks.plage.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationDto {

    LocalDate dateDebut;
    LocalDate dateFin;
    double montantAReglerEnEuros;
    String remarques;
    String numeroCarte;
    int moisExpiration;
    int anneeExpiration;
    String cryptogramme;
    Long idCLient;
}
