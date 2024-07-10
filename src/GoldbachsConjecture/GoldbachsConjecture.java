package GoldbachsConjecture;

import java.util.*;
import java.io.*;

public class GoldbachsConjecture {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		ArrayList<Integer> Primelist = new ArrayList<>();
		
		int Num = Integer.parseInt(bf.readLine());
		int[] list = new int[Num];
		int[] number = new int[Num];
		
		
		for(int i = 0; i < Num; i++) {
			int area = Integer.parseInt(bf.readLine());
			number[i] = area;
		}
		
		int Max = number[0];
		for(int i = 1; i < Num; i++) {
			if(Max < number[i]) {
				Max = number[i];
			}
		}
		
		boolean[] bool = new boolean[Max+1];
		
		for(int j = 2; j <= Max; j++) {
			bool[j] = true;
		}
		
		bool[0] = false;
		bool[1] = false;
		
		for(int j = 2; j*j <= Max; j++) {
			if(bool[j]) {
				for(int a = j*j; a <= Max; a+=j) {
					bool[a] = false;
				}
			}
		}
		
		for(int j = 2; j <= Max; j++) {
			if(bool[j]) {
				Primelist.add(j);
			}
		}
		
		
		for(int i = 0; i < Num; i++) {
			
			int count = 0;
			int count2 = 0;
			
			
			for(int j = 0; Primelist.get(j)*2 <= number[i]; j++) {
				for(int a = 0; (a < Primelist.size() && number[i] > Primelist.get(a)); a++) {
					if((Primelist.get(j) + Primelist.get(a)) == number[i]) {
						count++;
					}
				}
			}
			
			list[i] = count;
			
		}
		
		for(int i : list) {
			bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
	}

}
