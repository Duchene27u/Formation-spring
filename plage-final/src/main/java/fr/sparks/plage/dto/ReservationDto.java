package fr.sparks.plage.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Getter
@Setter
public class ReservationDto {

    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    private double montantAReglerEnEuros;
    private String remarques;
    private String numeroCarte;
    private byte moisExpiration;
    private short anneeExpiration;
    private String cryptogramme;
    private ClientDto clientDto;
  
    private List<ParasolDto> parasolsDto;

}
