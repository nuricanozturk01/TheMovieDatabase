package com.company.internshipProject.util;

import com.company.internshipProject.Entity.UserEntity;

public final class ControlUtil
{
    public static boolean isValidUserForSignUp(UserEntity user)
    {
        return !(user.getUsername().isBlank() || user.getUsername().isEmpty()) &&
                !(user.getPassword().isBlank() || user.getPassword().isEmpty()) &&
                !(user.getEmail().isBlank() || user.getEmail().isEmpty()) &&
                user.getUsername() != null && user.getPassword() != null && user.getEmail() != null;
    }
}
