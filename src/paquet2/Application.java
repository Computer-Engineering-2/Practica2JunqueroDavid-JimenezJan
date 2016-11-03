package paquet2;

import paquet1.*;
import java.io.*;

public class Application {

	public static void main(String args[]){
		String input;
		Character car='x';
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		DobleCuaEnll<Character> cua=new DobleCuaEnll<Character>();
		DobleCuaEnll<Character> pila=new DobleCuaEnll<Character>();
		
		System.out.println("Entra la frase a analitzar caracter a caracter");
		while(car!='.'){
			
			try{
				input=br.readLine();
				if(input.length()!=1)throw new Exception("Entra el text CARACTER A CARACTER");
				car=input.charAt(0);
			if(car!='.'){
				cua.addToRight(car);
				pila.addToLeft(car);
			}
			
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(esPalindrom(cua,pila)) System.out.println("La frase es palindrom");
		else System.out.println("La frase NO es palindrom");
	}
	
	private static boolean esPalindrom(DobleCuaEnll<Character> cua,DobleCuaEnll<Character> pila){  
																		
		while(!(cua.isEmpty() && pila.isEmpty())){
			
			char a=cua.getLeft();
			char b=pila.getLeft();
			
			cua.removeFromLeft();
			cua.removeFromRight();
			pila.removeFromRight();
			pila.removeFromLeft();
		
				if(!(Character.toLowerCase(a)==(Character.toLowerCase(b)))){  // No distingeix majúscules de minúscules.
					System.out.println("Diferéncia trobada. Elements restants: " + cua.length());
					System.out.println("Segment restant: " + cua);
					return false; 
				}
			}
			
		return true;
	}
	
}
