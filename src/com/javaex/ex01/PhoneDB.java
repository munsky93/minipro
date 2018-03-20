package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneDB {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		boolean my = true;

		System.out.println("*******************************************");
		System.out.println("                     전화번호 관리 프로그램            ");
		System.out.println("*******************************************");

		while (my) {

			System.out.println("1.리스트  2.둥록  3.삭제  4.검색  5.종료 ");
			System.out.println("-------------------------------------------");
			System.out.println(">메뉴번호:");

			int o = sc.nextInt();

			if (o == 1) {
				System.out.println("<1.리스트>");
				Reader rr = new FileReader("phoneDB.txt");
				BufferedReader br = new BufferedReader(rr);
				ArrayList<DB> al = new ArrayList<DB>();

				while (my) {

					String line = br.readLine();
					if (line == null)
						break;
					String j[] = line.split(",");
					al.add(new DB(j[0], j[1], j[2]));

				}

				for (int i = 0; i < al.size(); i++) {
					al.get(i).showinfo();
				}
				br.close();

			} else if (o == 2) {
				System.out.println("<2.등록>");
				Reader rr = new FileReader("phoneDB.txt");
				BufferedReader br = new BufferedReader(rr);
				ArrayList<DB> al = new ArrayList<DB>();

				while (my) {

					String line = br.readLine();
					if (line == null)
						break;
					String j[] = line.split(",");
					al.add(new DB(j[0], j[1], j[2]));
				}

				System.out.println(">이름:");
				String name = sc.next();
				System.out.println(">번호:");
				String ph = sc.next();
				System.out.println(">회사전화:");
				String com = sc.next();

				al.add(new DB(name, ph, com));

				Writer wr = new FileWriter("phoneDB.txt");
				BufferedWriter bw = new BufferedWriter(wr);

				System.out.println("[등록되었습니다.]");

				for (int j = 0; j < al.size(); j++) {

					bw.write(al.get(j).getName() + "," + al.get(j).getNum() + "," + al.get(j).getCompany());
					bw.newLine();
				}
				br.close();
				bw.close();

			} else if (o == 3) {
				System.out.println("<3.삭제>");
				Reader rr = new FileReader("phoneDB.txt");
				BufferedReader br = new BufferedReader(rr);
				ArrayList<DB> al = new ArrayList<DB>();

				while (my) {

					String line = br.readLine();
					if (line == null)
						break;
					String j[] = line.split(",");
					al.add(new DB(j[0], j[1], j[2]));
				}
				System.out.println(">번호:");
				int k = sc.nextInt();
				al.remove(k - 1);
				Writer wr = new FileWriter("phoneDB.txt");
				BufferedWriter bw = new BufferedWriter(wr);

				System.out.println("[삭제되었습니다.]");

				for (int j = 0; j < al.size(); j++) {

					bw.write(al.get(j).getName() + "," + al.get(j).getNum() + "," + al.get(j).getCompany());
					bw.newLine();
				}
				br.close();
				bw.close();

			} else if (o == 4) {
				System.out.println("<4.검색>");
				Reader rr = new FileReader("phoneDB.txt");
				BufferedReader br = new BufferedReader(rr);
				ArrayList<DB> al = new ArrayList<DB>();

				while (my) {

					String line = br.readLine();
					if (line == null)
						break;
					String j[] = line.split(",");
					al.add(new DB(j[0], j[1], j[2]));
				}
				System.out.println(">문자입력");
				String l = sc.next();
				for (int j = 0; j < al.size(); j++) {

					boolean g = al.get(j).getName().contains(l);
					if (g == my) {
						al.get(j).showinfo();
					}
				}
			} else if (o == 5) {
				my = false;
				System.out.println("*******************************************");
				System.out.println("                     감사합니다.             ");
				System.out.println("*******************************************");
			} else {
				System.out.println("[다시입력해주세요]");
			}
		}
	}
}