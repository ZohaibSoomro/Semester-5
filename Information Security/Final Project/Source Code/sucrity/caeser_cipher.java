/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sucrity;

/**
 *
 * @author adeel
 */
public class caeser_cipher {
    
    
  public String   Encrypted(String plaintext , int key)
  {
  
  
		int i,n;
		String str;
		String str1="";
	
		str=plaintext.toLowerCase();
		n=str.length();
		char ch1[]=str.toCharArray();
		char ch3,ch4;
		
		
		for(i=0;i<n;i++)
		{
			if(Character.isLetter(ch1[i]))
			{
				ch3=(char)(((int)ch1[i]+key-97)%26+97);
				//System.out.println(ch1[i]+" = "+ch3);
				str1=str1+ch3;
			}				
			else if(ch1[i]==' ')
			{
				str1=str1+ch1[i];
			}					
		}

                
                return str1;
  }
  
  public String decrypt (String plaintext , int key)
  {
  
      
    	int i,n;
		String str;
		String str1="";
		String str2="";
		System.out.println("Enter the plaintext");
	
		str=plaintext.toLowerCase();
		n=str.length();
		char ch1[]=str.toCharArray();
		char ch3,ch4;
		
                
		char ch2[]=plaintext.toCharArray();
		for(i=0;i<plaintext.length();i++)
		{
			if(Character.isLetter(ch2[i]))
			{
				if(((int)ch2[i]-key)<97)
				{
					ch4=(char)(((int)ch2[i]-key-97+26)%26+97);

				}
					else
				{
					ch4=(char)(((int)ch2[i]-key-97)%26+97);
				}
				str2=str2+ch4;
			}	
			
			else if(ch2[i]==' ')
			{
				str2=str2+ch2[i];
			}						
		}
		
                System.out.println(str2);
                return str2;
      
      
  
    
  }
    
    
    
}
