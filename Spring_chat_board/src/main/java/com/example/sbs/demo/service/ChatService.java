package com.example.sbs.demo.service;

import java.util.List;
import java.util.Map;

import com.example.sbs.demo.dto.ChatMessage;
import com.example.sbs.demo.dto.ChatRoom;

public interface ChatService {

	public Map<String, Object> doAdd(Map<String, Object> param);

	public List<ChatRoom> getList();

	public ChatRoom findById(int id);

	public Map<String, Object> addMessage(Map<String, Object> param);

	public List<ChatMessage> getMessages(int roomId, int from);

}

