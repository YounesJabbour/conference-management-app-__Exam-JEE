    package jabbour.younes.jabbour.DTOs.Employe;


    import lombok.*;

    @Getter
    @Setter
    @ToString
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class EmployeDTO {
        private Long id;
        private String name;
        private String email;
        private String photo;
    }

