package fr.sparks.plage.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NbInscrits {

    private int annee;
    private int mois;
    private Long nbr;
}
