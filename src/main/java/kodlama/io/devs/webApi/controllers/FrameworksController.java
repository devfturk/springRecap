package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.FrameworkService;
import kodlama.io.devs.business.requests.frameworkRequests.CreateFrameworkRequest;
import kodlama.io.devs.business.requests.frameworkRequests.DeleteFrameworkRequest;
import kodlama.io.devs.business.requests.frameworkRequests.UpdateFrameworkRequest;
import kodlama.io.devs.business.responses.frameworkResponses.GetAllFrameworkResponse;

@RestController
@RequestMapping("/api/frameworks")
public class FrameworksController {

	private FrameworkService frameworkService;

	@Autowired
	public FrameworksController(FrameworkService frameworkService) {
		this.frameworkService = frameworkService;
	}
	
    @GetMapping("/getall")
    public List<GetAllFrameworkResponse> getAll() {
        return frameworkService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public GetAllFrameworkResponse getById(@PathVariable("id") int id) {
        return frameworkService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody CreateFrameworkRequest createFrameworkRequest) throws Exception {
        try {
        	frameworkService.add(createFrameworkRequest);
            return ResponseEntity.created(null).body("created");
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    void update(@PathVariable("id") int id, @RequestBody UpdateFrameworkRequest updateFrameworkRequest) throws Exception {
        this.frameworkService.update(id, updateFrameworkRequest);
    }

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") int id, @RequestBody DeleteFrameworkRequest deleteFrameworkRequest) throws Exception {
        this.frameworkService.delete(id, deleteFrameworkRequest);
    }
	
	
	
}
