package com.example.sbs.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.sbs.demo.dto.ChatMessage;
import com.example.sbs.demo.dto.ChatRoom;

@Mapper
public interface ChatDao {
	public void add(Map<String, Object> param);

	public List<ChatRoom> getList();

	public ChatRoom findById(@Param("id") int id);

	public void addMessage(Map<String, Object> param);

	public List<ChatMessage> getMessages(@Param("roomId") int roomId, @Param("from") int from);
}
