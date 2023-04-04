package kodlama.io.devs.business.requests.frameworkRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFrameworkRequest {

    private String framework;
    private String programmingLanguage;
}
