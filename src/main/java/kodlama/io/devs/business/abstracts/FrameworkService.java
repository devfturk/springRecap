package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.frameworkRequests.CreateFrameworkRequest;
import kodlama.io.devs.business.requests.frameworkRequests.DeleteFrameworkRequest;
import kodlama.io.devs.business.requests.frameworkRequests.UpdateFrameworkRequest;
import kodlama.io.devs.business.responses.frameworkResponses.GetAllFrameworkResponse;

public interface FrameworkService {
	
	List<GetAllFrameworkResponse> getAll();

	GetAllFrameworkResponse getById(int id);

    void add(CreateFrameworkRequest createFrameworkRequest) ;

    void update(int frameworkId,UpdateFrameworkRequest updateFrameworkRequest);

    void delete(int frameworkId,DeleteFrameworkRequest deleteFrameworkRequest);
}
