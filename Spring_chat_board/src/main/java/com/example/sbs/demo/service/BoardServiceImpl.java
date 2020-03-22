package com.example.sbs.demo.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbs.demo.dao.BoardDao;
import com.example.sbs.demo.dto.Article;
import com.example.sbs.demo.dto.ArticleReply;
import com.example.sbs.demo.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;

	public Board findById(int boardId) {
		return boardDao.findById(boardId);
	}

	@Override
	public List<Article> getArticleList(Map<String, Object> param) {
		return boardDao.getArticleList(param);
	}

	@Override
	public Article findArticleById(int id) {
		return boardDao.findArticleById(id);
	}

	@Override
	public Map<String, Object> deleteArticle(int id) {
		boardDao.deleteArticle(id);

		Map<String, Object> rs = new HashMap<>();
		rs.put("resultCode", "S-1");
		rs.put("msg", id + "번 글을 삭제하였습니다.");

		return rs;
	}

	@Override
	public Map<String, Object> write(Map<String, Object> param) {
		boardDao.write(param);

		Map<String, Object> rs = new HashMap<>();

		rs.put("resultCode", "S-1");
		int id = ((BigInteger) param.get("id")).intValue();
		rs.put("msg", id + "번 글이 생성되었습니다.");
		rs.put("id", id);

		return rs;
	}

	@Override
	public Map<String, Object> modify(Map<String, Object> param) {
		boardDao.modify(param);

		Map<String, Object> rs = new HashMap<>();

		rs.put("resultCode", "S-1");
		rs.put("msg", param.get("id") + "번 글이 수정되었습니다.");

		return rs;
	}

	@Override
	public List<ArticleReply> getRepliesFrom(int articleId, int from) {
		return boardDao.getRepliesFrom(articleId, from);
	}

	@Override
	public Map<String, Object> writeReply(Map<String, Object> param) {
		boardDao.writeReply(param);

		Map<String, Object> rs = new HashMap<>();

		rs.put("resultCode", "S-1");
		int id = ((BigInteger) param.get("id")).intValue();
		rs.put("msg", id + "번 댓글이 생성되었습니다.");
		rs.put("id", id);

		return rs;
	}

	@Override
	public Map<String, Object> deleteReply(int id, int loginedMemberId) {
		Map<String, Object> rs = new HashMap<>();
		
		ArticleReply articleReply = boardDao.getReply(id);
		
		if ( loginedMemberId != articleReply.getMemberId() ) {
			rs.put("resultCode", "F-1");
			rs.put("msg", id + "권한이 없습니다.");
			
			return rs;
		}
		
		boardDao.deleteReply(id);

		rs.put("resultCode", "S-1");
		rs.put("msg", id + "번 댓글이 삭제되었습니다.");
		rs.put("id", id);

		return rs;
	}

	@Override
	public Map<String, Object> modifyReply(Map<String, Object> param, int loginedMemberId) {
		Map<String, Object> rs = new HashMap<>();
		
		int id = (int)param.get("id");
		
		ArticleReply articleReply = boardDao.getReply(id);
		
		if ( loginedMemberId != articleReply.getMemberId() ) {
			rs.put("resultCode", "F-1");
			rs.put("msg", id + "권한이 없습니다.");
			
			return rs;
		}
		
		boardDao.modifyReply(param);

		rs.put("resultCode", "S-1");
		rs.put("msg", id + "번 댓글이 수정되었습니다.");
		rs.put("id", id);

		return rs;
	}

	@Override
	public void increaseArticleHit(int id) {
		boardDao.increaseArticleHit(id);
	}
}
