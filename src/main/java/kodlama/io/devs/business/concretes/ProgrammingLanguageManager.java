package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.responses.languageResponses.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository;
	

	public ProgrammingLanguageManager() {
	}

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
        List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponses = new ArrayList<>();
        
        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {

            GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
            responseItem.setId(programmingLanguage.getId());
            responseItem.setName(programmingLanguage.getName());

            programmingLanguagesResponses.add(responseItem);

        }
		return programmingLanguagesResponses;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		if (programmingLanguage.getName().isEmpty()) {
			System.out.println("Programlama dili boş geçemez.");
			return;
		}
		for (ProgrammingLanguage programLanguage : programmingLanguageRepository.findAll()) {
			if (programLanguage.getName().toUpperCase().equals(programLanguage.getName().toUpperCase())) {
				System.out.println("Bu kurs sistemde zaten mevcut!");
				return;
			}
		}
		programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public void delete(ProgrammingLanguage programmingLanguage) {

		programmingLanguageRepository.delete(programmingLanguage);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GetAllProgrammingLanguagesResponse getById(int id) {
		
		GetAllProgrammingLanguagesResponse programmingLanguagesResponse = new GetAllProgrammingLanguagesResponse();
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).orElseThrow();
        programmingLanguagesResponse.setName(programmingLanguage.getName());

        return programmingLanguagesResponse;
	}

}
