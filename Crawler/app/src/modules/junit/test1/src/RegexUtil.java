package com.ai92.cooljunit;

public class RegexUtil{

    public static boolean checkEmail(String email){

         if(!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")){

             return false;

         }

         return true;

    }



}
