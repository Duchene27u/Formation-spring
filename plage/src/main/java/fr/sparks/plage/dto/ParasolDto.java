package fr.sparks.plage.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParasolDto {

    Long id;
    byte numEmplacement;
    @JsonIgnore
    List<ReservationDto> reservations;
}
