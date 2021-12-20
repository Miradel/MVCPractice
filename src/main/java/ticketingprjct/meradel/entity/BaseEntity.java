package ticketingprjct.meradel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    private Long id;
    private LocalDateTime insertDateTime;
    private Long insertUserID;
    private Long lastUpdatedTime;
    private LocalDateTime lastUpdateDataTime;



}
