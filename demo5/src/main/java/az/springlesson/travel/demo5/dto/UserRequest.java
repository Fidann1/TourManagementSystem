package az.springlesson.travel.demo5.dto;

import az.springlesson.travel.demo5.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Integer id;
    private String email;
    private String username;
    private String password;
    private Integer age;
    private RoleEnum role;
}
