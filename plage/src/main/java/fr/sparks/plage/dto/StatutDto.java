package fr.sparks.plage.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StatutDto implements Serializable {

    private final Long id;
    private final String nom;
}
