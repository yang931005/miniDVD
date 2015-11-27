package cn.zucc.test;

import java.text.ParseException;

import cn.zucc.dao.DvdDao;
import cn.zucc.view.DvdMenu;
public class DvdTest {

	/**
	 * @param args
	 * @throws ParseException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException{
		// TODO Auto-generated method stub
		
		//DvdDao dd = new DvdDao();	
//		dvd.setName("dsf");
//		dd.addDvd(dvd);
	//	Dvd dvd = new Dvd();
	//	dvd.setName("dgd");
	//	dd.updateDvd(dvd);
	//	DvdDao dvdDao = new DvdDao();
		
	//	dd.deleteDvd(5);
//		System.out.println(dd.findDvd(5));
	/*
		List<Dvd> list = new ArrayList<Dvd>();
		list =(dd.findallDvd());
		for(Dvd dvd:list){
			System.out.println(dvd);
		}
		*/
		
//		DvdManager dm = new DvdManager();
//		dm.DvdMain();
		
		DvdMenu dm = new DvdMenu();
		dm.DvdMain();
		
		
	}

}
