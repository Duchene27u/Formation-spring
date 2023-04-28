package fr.sparks.plage.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class FileDto {

    private final Long id;
    private final byte numero;
    private final double prixJournalier;
    @JsonIgnore
    private final List<ParasolDto> parasols;
}
