package org.devlos.practicemsaredecorder.interfaces.partner;

import lombok.Getter;
import lombok.ToString;
import org.devlos.practicemsaredecorder.domain.partner.Partner;
import org.devlos.practicemsaredecorder.domain.partner.PartnerCommand;
import org.devlos.practicemsaredecorder.domain.partner.PartnerInfo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class PartnerDto {
    public static class RegisterRequest {
        @NotEmpty(message = "partnerName 는 필수값입니다.")
        private String partnerName;

        @NotEmpty(message = "businessNo 는 필수값입니다.")
        private String businessNo;

        @Email(message = "이메일 형식에 맞야아 합니다.")
        @NotEmpty(message = "Email 는 필수값입니다.")
        private String email;

        public PartnerCommand toCommand() {
            return PartnerCommand.builder()
                    .partnerName(partnerName)
                    .businessNo(businessNo)
                    .email(email)
                    .build();
        }

    }

    @Getter
    @ToString
    public static class RegisterResponse {
        private final String partnerToken;
        private final String partnerName;
        private final String businessNo;
        private final String email;
        private final Partner.Status status;

        public RegisterResponse(PartnerInfo partnerInfo) {
            this.partnerToken = partnerInfo.getPartnerToken();
            this.partnerName = partnerInfo.getPartnerName();
            this.businessNo = partnerInfo.getBusinessNo();
            this.email = partnerInfo.getEmail();
            this.status = partnerInfo.getStatus();
        }
    }
}
