package com.example.einzelprojekt;

public class AlternateQuersumme {

    /**
     * Convert the String Input to an int array
     * @param mNr
     * @param array
     */
    public void stringToIntArray(String mNr, int[] array){
        for(int i = 0; i < mNr.length(); i++){
            array[i] = Integer.parseInt(String.valueOf(mNr.charAt(i)));
        }
    }

    /**
     * Form the alternating cross sum
     * @param array
     * @return
     */
    public int alternateQuersummeForward(int[] array){
        int sum = 0;
        for(int i = 0; i < array.length;i++){
            if(i % 2 == 0){
                sum+=array[array.length-1-i];
            }else{
                sum-=array[array.length-1-i];
            }
        }
        return sum;
    }
}
