package kodlama.io.devs.business.responses.frameworkResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllFrameworkResponse {
	private int id;
    private String name;
    private int programmingLanguageId;
}
