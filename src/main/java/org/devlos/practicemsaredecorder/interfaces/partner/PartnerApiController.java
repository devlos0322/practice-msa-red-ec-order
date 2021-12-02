package org.devlos.practicemsaredecorder.interfaces.partner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.devlos.practicemsaredecorder.application.partner.PartnerFacade;
import org.devlos.practicemsaredecorder.common.response.CommonResponse;
import org.devlos.practicemsaredecorder.domain.partner.PartnerCommand;
import org.devlos.practicemsaredecorder.domain.partner.PartnerInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApiController {
    private final PartnerFacade partnerFacade;

    public void registerPartner(@RequestBody @Valid PartnerDto.RegisterRequest request) {
        PartnerCommand command = request.toCommand();
        PartnerInfo partnerInfo = partnerFacade.registerPartner(command);
        var response = new PartnerDto.RegisterResponse(partnerInfo);
//        return CommonResponse.success(response);
    }
}
