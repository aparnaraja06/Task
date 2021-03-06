package operations;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import book.BookingInfo;
import hotel.HotelInfo;
import user.User;

public class HotelOperations{
	
	private int userId=0;

	List<HotelInfo> hotelList=new ArrayList<>();
	List<User> userList=new ArrayList<>();
	List<BookingInfo> bookList=new ArrayList<>();
		
	private int generateId() {
		return ++userId;
	}
	
	public void addDefaultHotels() {
		String[] name= {"Hotel1","Hotel2","Hotel3","Hotel4","Hotel5"};
		int[] rooms= {4,6,8,2,5};
		String[] location= {"Bangalore","Mumbai","Agra","Bangalore","Goa"};
		float[] rating= {3F,4F,5F,3.5F,4F};
		double[] price= {200,300,600,400,300};
		
		for(int i=0;i<name.length;i++)
		{
			HotelInfo hotel=new HotelInfo();
			
			hotel.setName(name[i]);
			hotel.setRooms(rooms[i]);
			hotel.setLocation(location[i]);
			hotel.setRating(rating[i]);
			hotel.setPrice(price[i]);
			
			hotelList.add(hotel);
			
		}
	}
	
	public void addDefaultUsers() {
		
		String[] name= {"User1","User2","User3"};
		String[] location= {"Ooty","Bangalore","Goa"};
		long[] mobile= {9857932473L,8493278945L,9845738257L};
		
		for(int i=0;i<name.length;i++)
		{
			int cust_id=generateId();
			User user=new User();
			
			user.setUserId(cust_id);
			user.setUserName(name[i]);
			user.setLocation(location[i]);
			user.setMobileNumber(mobile[i]);
			
			userList.add(user);
		}
		
		
	}
	
	public void addDefaultBooking()
	{
		int[] id= {1,2,3};
		String[] name= {"User1","User2","User3"};
		String[] hotel= {"Hotel1","Hotel2","Hotel3"};
		double[] cost= {1000,400,2000};
		
		for(int i=0;i<id.length;i++)
		{
			BookingInfo book=new BookingInfo();
			
			book.setHotelName(hotel[i]);
			book.setUserName(name[i]);
			book.setCost(cost[i]);
			book.setUserId(id[i]);
			
			bookList.add(book);
		}
	}
	
	
	public List<HotelInfo> getHotelData(){
		
		return hotelList;
	}
	
	public boolean addHotel(HotelInfo hotel)
	{
	     hotelList.add(hotel);
	     
	     return true;
	}
	
	
	public int  addUser(User user)
	{
		int cust_id=generateId();
		
		user.setUserId(cust_id);
		
		userList.add(user);
		
		return cust_id;
	}
	
	public List<HotelInfo> sortByName(){
		
		Collections.sort(hotelList,new Comparator<HotelInfo>(){

			@Override
			public int compare(HotelInfo name1, HotelInfo name2) {
				return name2.getName().compareTo(name1.getName());
			}
			
		});
	   
		return hotelList;
		
			
	}
	
	public List<HotelInfo> sortByRating()
	{
		Collections.sort(hotelList,new Comparator<HotelInfo>(){
           
			@Override
			public int compare(HotelInfo name1, HotelInfo name2) {
				if (name1.getRating() < name2.getRating()) {
					  return 1;
					} else if (name1.getRating() > name2.getRating()) {
					  return -1;
					} else {
					  return 0;
					}

			}
			
		});
	   
		return hotelList;
		
	}
	
	public List<HotelInfo> sortByRooms()
	{
		Collections.sort(hotelList,new Comparator<HotelInfo>(){

			@Override
			public int compare(HotelInfo name1, HotelInfo name2) {
				return name1.getRooms()-name2.getRooms();
			}
			
		});
	   
		return hotelList;
	}
	
	public List<HotelInfo> getLocaation(String location)
	{
		List<HotelInfo> list=new ArrayList<>();
		
		for(int i=0;i<hotelList.size();i++)
		{
			HotelInfo hotel=hotelList.get(i);
			String current=hotel.getLocation();
		    if(current.equalsIgnoreCase(location))
		    {
		    	list.add(hotel);
		    }
		}
		
		return list;
	}
	
	public List<BookingInfo> getBookingDetails(){
		return bookList;
	}

	
}
