package com.kj.springbasic.Service;

import com.kj.springbasic.dto.PostUserRequestDto;
import com.kj.springbasic.dto.SignInRequestDto;

public interface AuthService {
    String signUp(PostUserRequestDto dto);

    String signIn(SignInRequestDto dto);

}
