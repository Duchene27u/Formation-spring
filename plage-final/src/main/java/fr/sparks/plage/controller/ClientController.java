package fr.sparks.plage.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.sparks.plage.service.ClientService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ClientController {

	private final ClientService clientService;
	
	@GetMapping({"/", "clients"})
	public ModelAndView getClients(@PageableDefault(size = 10, sort = "nom") Pageable pageable,
			HttpServletRequest request) {
		System.out.println(new Date() + ", msDepart=" + request.getAttribute("msDepart"));
		ModelAndView mav = new ModelAndView("clients");
		mav.addObject("pageDeClients", clientService.recupererClients(pageable));
		String attributDeTri = pageable.getSort().iterator().next().getProperty();
		String directionDeTri = pageable.getSort().iterator().next().getDirection().name();
		mav.addObject("sort", attributDeTri + "," + directionDeTri);
		return mav;
	}
}
