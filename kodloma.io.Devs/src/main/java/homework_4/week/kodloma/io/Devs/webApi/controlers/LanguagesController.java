package homework_4.week.kodloma.io.Devs.webApi.controlers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import homework_4.week.kodloma.io.Devs.business.abstracts.LanguageService;
import homework_4.week.kodloma.io.Devs.entities.concretes.Language;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController // annotation
@RequestMapping("/api/languages")
public class LanguagesController {
	
	private LanguageService languageService;

	public LanguagesController(LanguageService languageservice) {
		
		this.languageService = languageservice;
	}

	@GetMapping
	public List<Language> getAll(){
		return languageService.getAll();
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) throws Exception {
		
		languageService.delete(id);
     }
	
	@GetMapping("{id}")
	public Language getByid(@PathVariable int id) throws Exception  {
		return languageService.getByid(id);
		
	}
		
		
	@PostMapping
	public void add(@RequestBody Language language) throws Exception {
		
	     languageService.add(language);
	}
	
	@PutMapping("/{id}") 
	public void update(@RequestBody Language language,@PathVariable int id) throws Exception {
		
		languageService.update(language, id);
		
	}
	
	
	
	
	
	
	
	
}
