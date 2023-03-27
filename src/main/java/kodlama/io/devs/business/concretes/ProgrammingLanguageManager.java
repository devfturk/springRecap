package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
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
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguageRepository.getAll();
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		if (programmingLanguage.getName().isEmpty()) {
			System.out.println("Programlama dili boş geçemez.");
			return;
		}
		for (ProgrammingLanguage programLanguage : programmingLanguageRepository.getAll()) {
			if (programLanguage.getName().toUpperCase().equals(programLanguage.getName().toUpperCase())) {
				System.out.println("Bu kurs sistemde zaten mevcut!");
				return;
			}
		}
		programmingLanguageRepository.add(programmingLanguage);
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
	public ProgrammingLanguage getById(int id) {
		
		return programmingLanguageRepository.getById(id);
	}

}
