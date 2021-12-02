package org.devlos.practicemsaredecorder.infrastructure.partner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.devlos.practicemsaredecorder.domain.partner.Partner;
import org.devlos.practicemsaredecorder.domain.partner.PartnerReader;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerReadImpl implements PartnerReader {
    private final PartnerRepository partnerRepository;

    @Override
    public Partner getPartner(Long partnerId) {
        return partnerRepository.findById(partnerId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Partner getPartner(String partnerToken) {
        return partnerRepository.finByPartnerToken(partnerToken)
                .orElseThrow(EntityNotFoundException::new);
    }
}
