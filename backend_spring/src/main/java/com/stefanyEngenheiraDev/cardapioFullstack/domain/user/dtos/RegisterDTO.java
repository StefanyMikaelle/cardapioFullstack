package com.stefanyEngenheiraDev.cardapioFullstack.domain.user.dtos;

import com.stefanyEngenheiraDev.cardapioFullstack.domain.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
