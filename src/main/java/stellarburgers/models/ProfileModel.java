package stellarburgers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProfileModel {
    private String name;
    private String email;
    private String password;
}
