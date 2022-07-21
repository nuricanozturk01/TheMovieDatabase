package com.company.internshipProject.PasswordGenerator;

import com.company.internshipProject.PasswordGenerator.PGExceptions.CharacterCountNotMatchedException;
import com.company.internshipProject.PasswordGenerator.PGExceptions.MinimumPasswordSizeException;
import com.company.internshipProject.PasswordGenerator.PGExceptions.WrongPasswordSizeException;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class PasswordGenerator implements IPasswordGenerator
{

    private final int MIN_PASSWORD_SIZE = 5;
    private final int SPECIAL_VALUE = 5;
    public static final int DEFAULT_PASSWORD_SIZE = 10;
    private final int UPPER_START       = 0x41;
    private final int UPPER_STOP        = 0x5A;
    private final int LOWER_START       = 0x61;
    private final int LOWER_STOP        = 0x7A;
    private final int NUMBER_START      = 0x30;
    private final int NUMBER_STOP       = 0x39;
    private final int SPECIAL_1_START   = 0x21;
    private final int SPECIAL_1_STOP    = 0x2F;
    private final int SPECIAL_2_START   = 0x3A;
    private final int SPECIAL_2_STOP    = 0x40;
    private final int SPECIAL_3_START   = 0x5B;
    private final int SPECIAL_3_STOP    = 0x5F;
    private final int SPECIAL_4_START   = 0x7B;
    private final int SPECIAL_4_STOP    = 0x7E;

    private final int[][] wordNumberList = new int[][]
            { {LOWER_START, LOWER_STOP}, {UPPER_START, UPPER_STOP}, {NUMBER_START, NUMBER_STOP} };

    private final int[][] specialList    = new int[][]
            {
                    {SPECIAL_1_START, SPECIAL_1_STOP}, {SPECIAL_2_START, SPECIAL_2_STOP},
                    {SPECIAL_3_START, SPECIAL_3_STOP}, {SPECIAL_4_START, SPECIAL_4_STOP}
            }; // Special Characters

    private String password;
    private int passwordSize;

    private int charCount;
    private int upperCount;
    private int lowerCount;
    private int numberCount;
    private int specialCount;

    private SecureRandom random;


    public PasswordGenerator(int upperCount, int lowerCount, int numberCount, int specialCount)
    {
        this.upperCount = upperCount;
        this.lowerCount = lowerCount;
        this.charCount = upperCount + lowerCount;
        this.numberCount = numberCount;
        this.specialCount = specialCount;
        this.passwordSize = charCount + numberCount + specialCount;
        random = new SecureRandom();
    }
    // For random
    public PasswordGenerator(int passwordSize)
    {
        this.passwordSize = passwordSize;
        random = new SecureRandom();
    }

    private void fillPassword(int[][] arr, int size, int row)
    {
        for (int i = 0; i < size; i++)
            password += Character.toString(random.nextInt(arr[row][1] - arr[row][0]) + arr[row][0]);
    }
    private void fillPassword(int[][] arr, int size)
    {

        for (int i = 0; i < size; i++)
        {
            int k = random.nextInt(3 - 0) + 0;
            password += Character.toString(random.nextInt(arr[k][1] - arr[k][0]) + arr[k][0]);
        }
    }
    private String shuffle(String str)
    {
        ArrayList<Character> lst = new ArrayList<>();

        for (int i = 0; i < str.length(); i++)
            lst.add(str.charAt(i));

        Collections.shuffle(lst);
        str = "";

        for (int i = 0; i < lst.size(); i++)
            str += lst.get(i);
        return str;
    }

    @Override
    public String customizedGenerate()
    {
        password = "";
        try
        {

            if (charCount != lowerCount + upperCount)
                throw new CharacterCountNotMatchedException();
            if (passwordSize <= MIN_PASSWORD_SIZE || passwordSize >= Integer.MAX_VALUE)
                throw new MinimumPasswordSizeException(MIN_PASSWORD_SIZE);
            if (lowerCount + upperCount + specialCount + numberCount != passwordSize)
                throw new WrongPasswordSizeException();

            if (charCount != 0)
            {
                if (lowerCount != 0)
                    fillPassword(wordNumberList,lowerCount,0);
                if (upperCount != 0)
                    fillPassword(wordNumberList,upperCount,1);
            }
            if (numberCount != 0)
                fillPassword(wordNumberList,numberCount,2);

            if (specialCount != 0)
                fillPassword(specialList,specialCount);
        }
        catch (Exception ex)
        {

        }
        password = shuffle(password);
        return password;
    }
    @Override
    public String randomGenerate()
    {
        random = new SecureRandom();
        password = "";
        try
        {
            if (passwordSize <= MIN_PASSWORD_SIZE || passwordSize >= Integer.MAX_VALUE)
                throw new MinimumPasswordSizeException(MIN_PASSWORD_SIZE);

            for (int i = 0; i < passwordSize; i++)
            {
                if (random.nextBoolean())
                    fillPassword(wordNumberList,1);

                else if (i % SPECIAL_VALUE == 0) fillPassword(specialList,1);

                else fillPassword(wordNumberList,1);
            }
        }
        catch (Exception ex)
        {

        }
        return password;
    }

}
