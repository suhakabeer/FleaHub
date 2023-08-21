package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Feedback;


public interface FeedbackDAO {
	public void  saveFeedback(Feedback  feedback);
	public  Feedback viewFeedback(String feedbackId);
	public  Feedback deleteFeedback(String feedbackId);
	public List<Feedback> ListAllFeedback();
	 
}

