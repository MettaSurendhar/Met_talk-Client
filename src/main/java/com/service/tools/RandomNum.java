package com.service.tools;

public class RandomNum {

	
	private static RandomNum instance;
	
	public static RandomNum getInstance() {
		if (instance == null) {
			instance = new RandomNum();
		}
		return instance;
	}
	

public String getRandomNum(int n)
 {
  String NumericString ="0123456789";
 
  StringBuilder strBuilRandom = new StringBuilder(n);
  for (int i = 0; i < n; i++) {
   int iRandom = (int)(NumericString.length()* Math.random());
   strBuilRandom.append(NumericString
      .charAt(iRandom));
  }
  
  String strRandom = strBuilRandom.toString();
  return strRandom;}

}
