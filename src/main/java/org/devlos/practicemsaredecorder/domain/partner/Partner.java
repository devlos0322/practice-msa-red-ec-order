package org.devlos.practicemsaredecorder.domain.partner;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.devlos.practicemsaredecorder.domain.AbstractEntity;

import org.apache.commons.lang3.StringUtils;
import javax.persistence.*;
import java.security.InvalidParameterException;

public class Partner extends AbstractEntity {
    private static final String PREFIX_PARTNER = "ptn_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partnerToken;
    private String partnerName;
    private String businessNo;
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("활성화"), DISABLE("비활성화");
        private final String description;
    }

    public Partner(String partnerName, String businessNo, String email) {
        if (StringUtils.isEmpty(partnerName)) throw new InvalidParameterException("empty partnerName");
        if (StringUtils.isEmpty(businessNo)) throw new InvalidParameterException("empty businessNo");
        if (StringUtils.isEmpty(email)) throw new InvalidParameterException("empty email");
        
//        this.partnerToken = TokenGenerator.
    }
}
