package com.example.sbs.demo.service;

import java.util.List;
import java.util.Map;

import com.example.sbs.demo.dto.Article;
import com.example.sbs.demo.dto.ArticleReply;
import com.example.sbs.demo.dto.Board;

public interface BoardService {
	public Board findById(int boardId);
	public List<Article> getArticleList(Map<String, Object> param);
	public Article findArticleById(int id);
	public Map<String, Object> deleteArticle(int id);
	public Map<String, Object> write(Map<String, Object> param);
	public Map<String, Object> modify(Map<String, Object> param);
	public List<ArticleReply> getRepliesFrom(int articleId, int from);
	public Map<String, Object> writeReply(Map<String, Object> param);
	public Map<String, Object> deleteReply(int id, int loginedMemberId);
	public Map<String, Object> modifyReply(Map<String, Object> param, int loginedMemberId);
	public void increaseArticleHit(int id);
}
