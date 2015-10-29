package cn.zucc.service;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import cn.zucc.dao.DvdDao;
import cn.zucc.entity.Dvd;
public class DvdManager {
	DvdDao dd = new DvdDao();
	
	//���DVD
	public void borrowDvd(int i ){
		DvdDao dao = new DvdDao();
		Dvd dvd = dao.findDvd(i);
		if(dvd.getState()==1){
		dvd.setBorrowdate(new Date());
		dvd.setReturndate(null);
		dvd.setState(0);
		dao.updateDvd(dvd);}else{
			System.out.println("DVD�ѽ��");
		}
	}
	
	//�黹DVD
	public void returnDvd(int i ){
		DvdDao dao = new DvdDao();
		Dvd dvd = dao.findDvd(i);
		if(dvd.getState()==0){
		dvd.setReturndate(new Date());
		long day = (dvd.getReturndate().getTime()-dvd.getBorrowdate().getTime())/(3600*1000*24);
		System.out.println("��Ҫ֧��"+day);
		dvd.setBorrowdate(null);
		dvd.setState(1);
		dao.updateDvd(dvd);
		}
		else{
			System.out.println("��DVDδ���");
		}
	}
	//DVD���а�
	public void Dvdtop(){
		System.out.println("id\t����\t״̬\t����");
		List<Dvd> list=dd.findallDvd();
		Collections.sort(list);
		for(Dvd dvd :list){
			System.out.println(dvd);
		}
	}
	
	//�����ҵ��������ݿ��е�DVD֮���show����
	public void show (){
		for(Dvd dvd:dd.findallDvd()){
			System.out.println(dvd);
		}
	}
	public void addDvd(){
		dd.addDvd();
	}
	public void findallDvd(){
		System.out.println("id\t����\t״̬\t����");
		dd.findallDvd();
	}
	public void deleteDvd(){
		dd.deleteDvd();
	}
	
}
