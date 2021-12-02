package org.devlos.practicemsaredecorder.application.partner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.devlos.practicemsaredecorder.domain.notification.NotificationService;
import org.devlos.practicemsaredecorder.domain.partner.PartnerCommand;
import org.devlos.practicemsaredecorder.domain.partner.PartnerInfo;
import org.devlos.practicemsaredecorder.domain.partner.PartnerService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
// @Todo RequiredArgsConstructor??
@RequiredArgsConstructor
public class PartnerFacade {
    private final PartnerService partnerService;
    private final NotificationService notificationService;

    public PartnerInfo registerPartner(PartnerCommand command) {
        PartnerInfo partnerInfo = partnerService.registerPartner(command);
        notificationService.sendEmail(partnerInfo.getEmail(), "title", "description");
        return partnerInfo;
    }
}
