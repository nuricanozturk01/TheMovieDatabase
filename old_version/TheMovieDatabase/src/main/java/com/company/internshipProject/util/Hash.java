package com.company.internshipProject.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Hash
{
    public static String hashing(String password)
    {
        String hashingPassword = null;
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            byte[] msg = md.digest(password.getBytes());

            BigInteger bigint = new BigInteger(1,msg);

            hashingPassword = bigint.toString(16);

            while (hashingPassword.length() < 32)
                hashingPassword = "0"+hashingPassword;
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        return hashingPassword;
    }


}
