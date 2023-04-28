package fr.sparks.plage.service.impl;

import fr.sparks.plage.dao.ClientDao;
import fr.sparks.plage.dto.ClientDto;
import fr.sparks.plage.entity.Client;
import fr.sparks.plage.mapper.ClientMapper;
import fr.sparks.plage.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ClientServiceImpl implements ClientService, UserDetailsService {

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username.trim().isEmpty()) {
			throw new UsernameNotFoundException("username is empty");
		}
		Optional<Client> optClient = clientDao.findByEmail(username);
		if (optClient.isEmpty()) {
			throw new UsernameNotFoundException("user " + username + " not found");
		}
		List<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(optClient.get());
		User user = new User(optClient.get().getEmail(), optClient.get().getMdp(), grantedAuthorities);
		System.out.println(user);
		return user;

	}

	private List<GrantedAuthority> getGrantedAuthorities(Client client) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}
}
