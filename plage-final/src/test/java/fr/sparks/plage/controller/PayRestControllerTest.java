package fr.sparks.plage.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.sparks.plage.dto.PaysDto;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaysRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	private PaysDto paysDto = new PaysDto();
	String code = "aa";
	String nom = "TEST";

	@Test
	@Order(1)
	void testerAjouterPays() throws Exception {

		paysDto.setCode(code);
		paysDto.setNom(nom);

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/pays")
				// On ajoute dans le corps de la requête un objet paysDto
				.content(objectMapper.writeValueAsString(paysDto))
				.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(code))
				.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value(nom))
				.andExpect(status().isCreated())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	@Order(2)
	void testerPatcherPays() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/api/pays/{code}/{nom}", code, nom)
				.contentType(MediaType.APPLICATION_JSON);

		mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.jsonPath("$.nom").value(nom))
				.andExpect(MockMvcResultMatchers.jsonPath("$.code").value(code))
				.andExpect(status().is2xxSuccessful())
				.andDo(MockMvcResultHandlers.print());
	}
	
	// TODO ajouter une méthode pour vérifier que le patch envoie un 404 si le code du pays n'existe pas en base
	
	// TODO ajouter une méthode pour tester la suppression d'un pays
	
}