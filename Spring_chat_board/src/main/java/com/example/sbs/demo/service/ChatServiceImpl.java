package com.example.sbs.demo.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbs.demo.dao.ChatDao;
import com.example.sbs.demo.dto.ChatMessage;
import com.example.sbs.demo.dto.ChatRoom;

@Service
public class ChatServiceImpl implements ChatService {
	@Autowired
	private ChatDao chatDao;

	@Override
	public Map<String, Object> doAdd(Map<String, Object> param) {
		chatDao.add(param);

		Map<String, Object> rs = new HashMap<>();

		rs.put("resultCode", "S-1");
		rs.put("msg", "채팅방이 생성되었습니다.");
		int id = ((BigInteger) param.get("id")).intValue();
		rs.put("id", id);

		return rs;
	}

	@Override
	public List<ChatRoom> getList() {
		return chatDao.getList();
	}

	@Override
	public ChatRoom findById(int id) {
		return chatDao.findById(id);
	}

	@Override
	public Map<String, Object> addMessage(Map<String, Object> param) {
		chatDao.addMessage(param);

		Map<String, Object> rs = new HashMap<>();

		rs.put("resultCode", "S-1");
		rs.put("msg", "채팅 메세지가 생성되었습니다.");
		int id = ((BigInteger) param.get("id")).intValue();
		rs.put("id", id);

		return rs;
	}

	@Override
	public List<ChatMessage> getMessages(int roomId, int from) {
		return chatDao.getMessages(roomId, from);
	}
}
