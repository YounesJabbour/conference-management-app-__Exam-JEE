package jabbour.younes.jabbour.DTOs.Employe;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatedEmployeDTO {
    private String name;
    private String email;
    private MultipartFile photo;
}
