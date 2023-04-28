package fr.sparks.plage.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Concessionnaire extends Utilisateur{

    private String numTelephone;
}
