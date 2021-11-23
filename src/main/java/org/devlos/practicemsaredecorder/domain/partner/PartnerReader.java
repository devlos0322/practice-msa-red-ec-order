package org.devlos.practicemsaredecorder.domain.partner;

public interface PartnerReader {
    Partner getPartner(Long partnerId);
    Partner getPartner (String partnerToken);
}
