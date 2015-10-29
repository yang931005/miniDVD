package cn.zucc.view;

import java.text.ParseException;
import java.util.Scanner;
import cn.zucc.service.DvdManager;
public class DvdMenu {
	Scanner sc = new Scanner(System.in);
	DvdManager dm = new DvdManager();
	public void DvdMain() throws ParseException{
		System.out.println("1.新增DVD");
		System.out.println("2.查看DVD");
		System.out.println("3.删除DVD");
		System.out.println("4.借出DVD");
		System.out.println("5.归还DVD");
		System.out.println("6.Dvd借出排行榜");
		System.out.println("7.退出");
		System.out.println("请选择：");
		
		switch(sc.nextInt()){
		case 1: 
			dm.addDvd();
			System.out.println("按0返回主菜单");
			if(sc.nextInt()==0){
				DvdMain();	
			}
			;break;
		case 2: 
			dm.findallDvd();
			dm.show();
			System.out.println("按0返回主菜单");
			if(sc.nextInt()==0){
				DvdMain();	
			}
			break;
		case 3: 
			dm.deleteDvd();
			break;
		case 4: 
			System.out.println("请输入需要借的书的ID");
			int i = sc.nextInt();
			dm.borrowDvd(i);
			System.out.println("按0返回主菜单");
			if(sc.nextInt()==0){
				DvdMain();	
			}
			break;
		case 5:
			System.out.println("请输入需要还的书的ID");
			int j = sc.nextInt();
			dm.returnDvd(j);
			System.out.println("按0返回主菜单");
			if(sc.nextInt()==0){
				DvdMain();	
			}
			break;
		case 6:
			dm.Dvdtop();
			System.out.println("按0返回主菜单");
			if(sc.nextInt()==0){
				DvdMain();	
			}
			break;
		case 7:
			System.out.println("谢谢使用！");break;
		default : 
			System.out.println("输入有误");break;
		}
	
	}
}
