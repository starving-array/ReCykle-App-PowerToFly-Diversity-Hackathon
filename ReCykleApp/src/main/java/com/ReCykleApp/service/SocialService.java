package com.ReCykleApp.service;

import com.ReCykleApp.donateModule.Book;
import com.ReCykleApp.donateModule.Cloth;
import com.ReCykleApp.donateModule.Food;
import com.ReCykleApp.exception.OtherException;

public interface SocialService {

	// giving donation
	public Book givingBookforDonation(Book book, String sessionId) throws OtherException;

	public Cloth givingClothforDonation(Cloth cloth, String sessionId) throws OtherException;

	public Food givingFoodforDonation(Food food, String sessionId) throws OtherException;

	// asking for donation
	public Book AskBookForDonation(String bookname, String sessionId) throws OtherException;

	public Cloth AskClothForDonation(Cloth cloth, String sessionId) throws OtherException;

	public Food AskFoodForDonation(Food food, String sessionId) throws OtherException;

	// booking from donation
	public Book BookingBookfromDonation(String sessionId, Integer donationId) throws OtherException;

	public Cloth BookingclothfromDonation(String sessionId, Integer donationId) throws OtherException;

	public Food BookingFoodfromDonation(String sessionId, Integer donationId) throws OtherException;

	// getting from the donnor
	public Book gettingBookfromDonation(String OTP, Integer dinationId) throws OtherException;

	public Cloth gettingClothfromDonation(String OTP, Integer dinationId) throws OtherException;

	public Food gettingFoodfromDonation(String OTP, Integer dinationId) throws OtherException;

}
