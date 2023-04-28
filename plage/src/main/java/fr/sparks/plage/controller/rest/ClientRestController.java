package fr.sparks.plage.controller.rest;

import fr.sparks.plage.dto.ClientDto;
import fr.sparks.plage.entity.Client;
import fr.sparks.plage.exception.ClientInexistantException;
import fr.sparks.plage.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
@AllArgsConstructor
public class ClientRestController {

	private ClientService clientService;

	@GetMapping("clients")
	public Page<Client> getClients(@PageableDefault(size = 10, sort = "prenom") Pageable pageable) {
		if (pageable == null) {
			pageable = PageRequest.of(0, 10, Direction.ASC, "prenom");
		}
		return clientService.recupererClients(pageable);
	}

	@PostMapping("clients")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Client postClient(@RequestBody ClientDto clientDto) {
		return clientService.enregistrerClient(clientDto);
	}

	@DeleteMapping("clients/{id}")
	public void deleteClient(Long id) {
		clientService.supprimerClient(id);
	}

	@ExceptionHandler(ClientInexistantException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String traiterClientInexistant(Exception exception) {
		return exception.getMessage();
	}
}