package cn.zucc.entity;

import java.util.Date;

public class Dvd implements Comparable<Dvd> {
	private int id;
	private int state;
	private String name;
	private Date borrowdate;
	private Date returndate;
	private int borrowcount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(Date borrowdate) {
		this.borrowdate = borrowdate;
	}
	public Date getReturndate() {
		return returndate;
	}
	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}
	
	
	public int getBorrowcount() {
		return borrowcount;
	}
	public void setBorrowcount(int borrowcount) {
		this.borrowcount = borrowcount;
	}
	
	@Override
	public String toString() {
		return id +"\t"  +name + "\t"+ state  + "\t"+borrowcount ;
	}
	@Override
	public int compareTo(Dvd o) {
		// TODO Auto-generated method stub
		return o.getBorrowcount()-this.getBorrowcount();
	}
	
	
}
