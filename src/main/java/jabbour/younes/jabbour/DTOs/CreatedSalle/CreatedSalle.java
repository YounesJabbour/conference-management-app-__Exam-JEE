package jabbour.younes.jabbour.DTOs.CreatedSalle;

import jabbour.younes.jabbour.enums.SalleType;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatedSalle {
    private String number;
    private String name;
    private int capacity;
    private SalleType type;
}
