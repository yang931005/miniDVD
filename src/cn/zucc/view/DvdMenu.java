package cn.zucc.view;

import java.text.ParseException;
import java.util.Scanner;
import cn.zucc.service.DvdManager;
public class DvdMenu {
	Scanner sc = new Scanner(System.in);
	DvdManager dm = new DvdManager();
	public void DvdMain() throws ParseException {
		System.out.println("1.����DVD");
		System.out.println("2.�鿴DVD");
		System.out.println("3.ɾ��DVD");
		System.out.println("4.���DVD");
		System.out.println("5.�黹DVD");
		System.out.println("6.Dvd������а�");
		System.out.println("7.�˳�");
		System.out.println("��ѡ��");
		
		switch(sc.nextInt()){
		case 1: 
			System.out.println("��������Ҫ��ӵ�DVD����");
			dm.addDvd(sc.next());
			returnMenu();
			;break;
		case 2: 
			dm.findallDvd();
			dm.show();
			returnMenu();
			break;
		case 3: 
			System.out.println("��������Ҫɾ����DVD��ID");
			dm.deleteDvd(sc.nextInt());
			returnMenu();
			break;
		case 4: 
			System.out.println("��������Ҫ������ID");
			int i = sc.nextInt();
			dm.borrowDvd(i);
			returnMenu();
			break;
		case 5:
			System.out.println("��������Ҫ�������ID");
			int j = sc.nextInt();
			dm.returnDvd(j);
			returnMenu();
			break;
		case 6:
			dm.Dvdtop();
			System.out.println("��0�������˵�");
			if(sc.nextInt()==0){
				DvdMain();	
			}
			break;
		case 7:
			System.out.println("ллʹ�ã�");break;
		default : 
			System.out.println("��������");break;
		}
		
		
		
	
	}
	public void returnMenu() throws ParseException{
		System.out.println("��0�������˵�");
		if(sc.nextInt()==0){
			DvdMain();	
		}
	}
}
