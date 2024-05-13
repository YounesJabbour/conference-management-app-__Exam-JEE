package jabbour.younes.jabbour.DTOs.Employe;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedEmployeDTO {
    private Long id;
    private String name;
    private String email;
    private MultipartFile photo;
}
