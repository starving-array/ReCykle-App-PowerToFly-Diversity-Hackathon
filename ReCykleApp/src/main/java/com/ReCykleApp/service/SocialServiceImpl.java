package com.ReCykleApp.service;

import org.springframework.stereotype.Service;

import com.ReCykleApp.donateModule.Book;
import com.ReCykleApp.donateModule.Cloth;
import com.ReCykleApp.donateModule.Food;
import com.ReCykleApp.exception.OtherException;

@Service
public class SocialServiceImpl implements SocialService {

	@Override
	public Book givingBookforDonation(Book book, String sessionId) throws OtherException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cloth givingClothforDonation(Cloth cloth, String sessionId) throws OtherException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food givingFoodforDonation(Food food, String sessionId) throws OtherException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book AskBookForDonation(String bookname, String sessionId) throws OtherException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cloth AskClothForDonation(Cloth cloth, String sessionId) throws OtherException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food AskFoodForDonation(Food food, String sessionId) throws OtherException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book BookingBookfromDonation(String sessionId, Integer donationId) throws OtherException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cloth BookingclothfromDonation(String sessionId, Integer donationId) throws OtherException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food BookingFoodfromDonation(String sessionId, Integer donationId) throws OtherException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book gettingBookfromDonation(String OTP, Integer dinationId) throws OtherException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cloth gettingClothfromDonation(String OTP, Integer dinationId) throws OtherException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food gettingFoodfromDonation(String OTP, Integer dinationId) throws OtherException {
		// TODO Auto-generated method stub
		return null;
	}

}
