package fr.sparks.plage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class LienDeParente {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String nom;
    @NonNull
    private float coefficient;
}
