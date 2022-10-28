package homework_4.week.kodloma.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import homework_4.week.kodloma.io.Devs.business.abstracts.LanguageService;
import homework_4.week.kodloma.io.Devs.dataAccess.abstracts.LanguageRepository;
import homework_4.week.kodloma.io.Devs.entities.concretes.Language;

@Service // bu sınıf bir business nesnesidir
public class LanguageManager implements LanguageService {

	
	
	private LanguageRepository languageRepository;
	
	
	
	@Autowired  // brandservicein implemente eden classı newleyerek getiriyor
	public LanguageManager(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}



	@Override
	public List<Language> getAll() {
		// dilleri listeleyeceğimiz kodlar
		return languageRepository.getAll();
	}



	@Override
	public void delete(int id) throws Exception {
		
		   if(!isExistId(id)) {
			   throw new Exception("Id bulunamadı");
		   }
		
	      languageRepository.delete(id);
	      
	      
	 }







	@Override
	public void add(Language language) throws Exception {
		if(isExistName(language.getName())) {
			throw new Exception ("İsim tekrar edemez");
		}
		if(isExistId(language.getId())) {
			throw new Exception ("ID tekrar edemez");
		}
		
		languageRepository.add(language);
			
	}



	@Override
	public Language getByid(int id) throws Exception {
		
		return languageRepository.getByid(id);
	}


	public boolean isExistId(int id) {
		List<Language> languages=getAll();
		for(Language lng:languages) {
			if(lng.getId()==id) {
				return true;
			}
			
		}
		return false;
		
	}
	
	public boolean isExistName(String name) {
		List<Language> languages=getAll();
		for(Language lng:languages) {
			if(lng.getName()==name) {
				return true;
			}
			
		}
		return false;
		
	}

	



	@Override
	public void update(Language language, int id) throws Exception {
		if(!isExistId(id)) {
		 
			throw new Exception("ID bulunamadı");
		}
		if(isExistName(language.getName())) {
			throw new Exception ("İsim tekrar edemez");
		}
		
		languageRepository.update(language, id);
		
	}

	
	
	
	
}
