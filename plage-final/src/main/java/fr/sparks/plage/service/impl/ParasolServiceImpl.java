package fr.sparks.plage.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.sparks.plage.business.Parasol;
import fr.sparks.plage.dao.ParasolDao;
import fr.sparks.plage.exception.ParasolInexistantException;
import fr.sparks.plage.service.ParasolService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ParasolServiceImpl implements ParasolService {

	private final ParasolDao parasolDao;
	
	@Override
	public Page<Parasol> recupererParasols(Pageable pageable) {
		return parasolDao.findAll(pageable);
	}

	@Override
	public Page<Parasol> recupererParasols(Pageable pageable, Long idFile) {
		return parasolDao.findByFileId(pageable, idFile);
	}

	@Override
	public Parasol enregistrerParasol(Parasol parasol) {
		return parasolDao.save(parasol);
	}

	@Override
	public Parasol recupererParasol(Long idParasol) {
		return parasolDao.findById(idParasol).orElse(null);
	}

	@Override
	public Parasol mettreAJourParasol(Long id, Byte nouveauNumEmplacement) {
		Parasol parasol = recupererParasol(id);
		if (parasol==null) {
			throw new ParasolInexistantException("Ce parasol n'existe pas");
		}
		parasol.setNumEmplacement(nouveauNumEmplacement);
		return enregistrerParasol(parasol);
	}

}