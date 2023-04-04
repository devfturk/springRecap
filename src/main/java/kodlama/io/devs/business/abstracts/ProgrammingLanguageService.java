package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.responses.languageResponses.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {

	List<GetAllProgrammingLanguagesResponse> getAll();
	
	GetAllProgrammingLanguagesResponse getById(int id);
	
	void add(ProgrammingLanguage programmingLanguage);
	
	void delete(ProgrammingLanguage programmingLanguage);
	
	void update(ProgrammingLanguage programmingLanguage);
}
