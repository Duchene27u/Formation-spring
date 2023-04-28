package fr.sparks.plage.service.impl;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import fr.sparks.plage.business.Client;
import fr.sparks.plage.dao.ClientDao;
import fr.sparks.plage.dto.ClientDto;
import fr.sparks.plage.mapper.ClientMapper;
import fr.sparks.plage.service.ClientService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

	private final ClientDao clientDao;
	private final ClientMapper clientMapper;
	
	@Override
	public Client enregistrerClient(Client client) {
		return clientDao.save(client);
	}
	
	@Override
	public Client enregistrerClient(ClientDto clientDto) {
		Client client = clientMapper.toEntity(clientDto);
		if (client.getDateHeureInscription()==null) {
			client.setDateHeureInscription(LocalDateTime.now());
		}
		return enregistrerClient(client);
	}
	
	@Override
	public Page<Client> recupererClients(Pageable pageable) {
		return clientDao.findAll(pageable);
	}

	@Override
	public boolean supprimerClient(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
