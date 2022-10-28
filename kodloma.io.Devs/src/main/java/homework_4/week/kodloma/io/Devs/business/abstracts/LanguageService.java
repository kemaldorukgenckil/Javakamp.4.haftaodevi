package homework_4.week.kodloma.io.Devs.business.abstracts;

import java.util.List;

import homework_4.week.kodloma.io.Devs.entities.concretes.Language;

public interface LanguageService {

	List<Language> getAll();
	Language getByid(int id) throws Exception;
	void delete(int id) throws Exception;
	void add(Language language) throws Exception;
	void update(Language language,int id) throws Exception;
	
}
