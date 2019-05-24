;

public class BruteForceAttack {
	public static char karakteri(int[] numri) {
		int nr = 0;

		for (int i = 7; i >= 0; i--) {
			nr = nr + (numri[7 - i] * (int) Math.pow(2, i));
		}
		char karakter = (char) nr;
		
		return karakter;
	}

	public static void main(String[] args){
		
	
	
		String cipherText = "15629177698EF862D42F77E8F862B7F8E87706CB8EC72F5A62C75A6215CBCB0DC7F8B762447706CB8E2FA9779DCB4C06";
		String cipher="";
		for(int i =0;i!=cipherText.length();i+=2)
		{
			int a=Integer.parseInt(cipherText.charAt(i)+""+cipherText.charAt(i+1), 16);
			String b=Integer.toBinaryString(a);
			for(int j=b.length();j!=8;j++)
			{
				b="0"+b;
			}
			cipher+=b;
		}
		//System.out.println(cipher);
		
		for(int i=0;i!=1024;i++)
		{
			int key[] = new int[10] ;
			String b = Integer.toBinaryString(i);
				for(int index = b.length(); b.length() != 10 ; index ++){
					b = "0"+b ;
				}
			for(int j = 0 ; j != 10 ; j ++)
			{	key[j] = new Integer(b.charAt(j)+"").intValue() ;
				System.out.print(key[j]);
			}
			System.out.print("--");
			String decipher="";
			for(int j = 0 ; j != cipher.length()/8 ; j ++){
				int bytes[] = new int[8] ;
				
				for(int k = 0 ;k != 8 ; k ++){
					bytes[k] = new Integer(cipher.charAt(8*j+k)+"").intValue();
				}
				bytes = Decryption.decryption(bytes, key);
				
				
				if( ( karakteri(bytes) <= 'Z'&& karakteri(bytes) >= 'A')
						|| karakteri(bytes) == ' '
							|| karakteri(bytes) <= 'z'&& karakteri(bytes) >= 'a'
								)
				decipher += karakteri(bytes);
		}
		System.out.println(decipher);
		}
	}//1010000010
		
}
