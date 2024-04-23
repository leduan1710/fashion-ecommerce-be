package it.spkt.fashionecommercebe.model.dto.user;

import it.spkt.fashionecommercebe.common.RankEnum;
import it.spkt.fashionecommercebe.common.SexEnum;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {
    private int id;

    private String name;
    private String image;
    private String email;
    private String phone;
    private SexEnum sex;
    private Date birthDay;
    private int point;
    private RankEnum rankUser;
}
