package fr.sparks.plage.controller.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.sparks.plage.business.Pays;
import fr.sparks.plage.dto.PaysDto;
import fr.sparks.plage.exception.PaysExistantException;
import fr.sparks.plage.exception.PaysInexistantException;
import fr.sparks.plage.service.PaysService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/")
public class PaysRestController {
	
	private final PaysService paysService;

	@Operation(description = "Récupère tous les pays")
	@GetMapping("pays")
	public List<Pays> getPays() {
		return paysService.recupererPays();
	}

	@Operation(description = "Ajoute un pays en utilisant les données présentes dans l'URL")
	@PostMapping("paysOldSchool/{code}/{nom}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Pays postPays(String code, String nom) {
		return paysService.ajouterPays(code, nom);
	}

	@Operation(description = "Ajoute un pays en utilisant les données présentes dans le corps de la requête")
	@PostMapping("pays")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pays postPaysDto(@RequestBody PaysDto paysDto){
        return paysService.ajouterPays(paysDto);
    }
	
	@Operation(description = "Met à jour le nom d'un pays")
	@PatchMapping("pays/{code}/{nouveauNom}")
	public Pays patchPays(@PathVariable String code, @PathVariable String nouveauNom) {
		return paysService.mettreAJour(code, nouveauNom);
	}
	
	@Operation(description = "Met à jour complètement le pays")
    @PutMapping("pays")
	@ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Pays> putPays(@RequestBody PaysDto paysDto) {
         if (paysDto.getCode() != null)
         {
             if (paysService.recupererPays(paysDto.getCode()) != null)
             {
                 Pays pays = paysService.enregistrerPays(paysDto);
                 return ResponseEntity.status(200).body(pays);
             }
             else
             {
                 return ResponseEntity.status(404).body(null);
             }
         }
         else
         {
             return ResponseEntity.status(400).body(null);
         }
    }

	@Operation(description = "Supprime un pays")
	@DeleteMapping("pays/{code}")
	public boolean deletePays(@PathVariable String code) {
		return paysService.supprimerPays(code);
	}
	
	@ExceptionHandler(PaysInexistantException.class)
    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    public String traiterPaysInexistant(Exception exception) {
        return exception.getMessage();
    }
	
	@ExceptionHandler(PaysExistantException.class)
    @ResponseStatus(code=HttpStatus.NOT_FOUND)
    public String traiterPaysExistant(Exception exception) {
        return exception.getMessage();
    }
	
}