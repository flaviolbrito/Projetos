package com.travels.api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.travels.api.enumeration.TravelTypeEnum;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Travel {

    private Long id;
    private String orderNumber;
    private BigDecimal amount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private TravelTypeEnum type;
//    private List<Link> links;

    public Travel(TravelTypeEnum type){
        this.type = type;
    }

//    public void addLink(Link link) {
//        if(links == null) links = new ArrayList<>();
//        links.add(link);
//}

}