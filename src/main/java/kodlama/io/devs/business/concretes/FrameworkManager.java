package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.FrameworkService;
import kodlama.io.devs.business.requests.frameworkRequests.CreateFrameworkRequest;
import kodlama.io.devs.business.requests.frameworkRequests.DeleteFrameworkRequest;
import kodlama.io.devs.business.requests.frameworkRequests.UpdateFrameworkRequest;
import kodlama.io.devs.business.responses.frameworkResponses.GetAllFrameworkResponse;
import kodlama.io.devs.dataAccess.abstracts.FrameworkRepository;
import kodlama.io.devs.entities.concretes.Framework;
@Service
public class FrameworkManager implements FrameworkService {

	private FrameworkRepository frameworkRepository;
	
	
	public FrameworkManager() {}

	@Autowired
	public FrameworkManager(FrameworkRepository frameworkRepository) {
		this.frameworkRepository = frameworkRepository;
	}

	@Override
	public List<GetAllFrameworkResponse> getAll() {
		List<Framework> frameworks = frameworkRepository.findAll();
		List<GetAllFrameworkResponse> list = new ArrayList<GetAllFrameworkResponse>();
		
		for (Framework framework : frameworks) {
			GetAllFrameworkResponse responseItem = new GetAllFrameworkResponse();
			responseItem.setName(framework.getName());
			responseItem.setProgrammingLanguageId(framework.getId());
			list.add(responseItem);
		}
		
		return list;
	}

	@Override
	public GetAllFrameworkResponse getById(int id) {
		GetAllFrameworkResponse frameworkReponse = new GetAllFrameworkResponse();
        Framework framework = frameworkRepository.findById(id).orElseThrow();
        frameworkReponse.setName(framework.getName());

        return frameworkReponse;
	}

	@Override
	public void add(CreateFrameworkRequest createFrameworkRequest) {
		Framework framework = new Framework();
		framework.setName(createFrameworkRequest.getFramework());
        //technology.set(technology.getProgrammingLanguage().getId());
        frameworkRepository.save(framework);
		
	}

	@Override
	public void update(int frameworkId, UpdateFrameworkRequest updateFrameworkRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int frameworkId, DeleteFrameworkRequest deleteFrameworkRequest) {
		// TODO Auto-generated method stub
		Framework framework = frameworkRepository.findById(frameworkId).orElseThrow();

        this.frameworkRepository.deleteById(frameworkId);
	}

}
