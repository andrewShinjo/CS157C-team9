package com.PeerReviewResume.backend.converters;

import com.PeerReviewResume.backend.commands.UserForm;
import com.PeerReviewResume.backend.entity.UserCredentials;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserFormToUserCredentials implements Converter<UserForm, UserCredentials> {
    @Override
    public UserCredentials convert(UserForm userForm) {
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setEmail(userForm.getEmail());
        userCredentials.setPassword(userForm.getPassword());
        return userCredentials;
    }
}
