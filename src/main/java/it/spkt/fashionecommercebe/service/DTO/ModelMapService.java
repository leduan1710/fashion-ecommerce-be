package it.spkt.fashionecommercebe.service.DTO;

import it.spkt.fashionecommercebe.model.dto.category.CategoryDTO;
import it.spkt.fashionecommercebe.model.dto.user.UserInfoDTO;
import it.spkt.fashionecommercebe.model.entity.category.Category;
import it.spkt.fashionecommercebe.model.entity.user.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ModelMapService {
    @Autowired
    ModelMapper modelMapper;
    public UserInfoDTO changeUserToDTO(User user){
        UserInfoDTO userInfoDTO= new UserInfoDTO();

        userInfoDTO = modelMapper.map(user,UserInfoDTO.class);

        return userInfoDTO;
    }

}
