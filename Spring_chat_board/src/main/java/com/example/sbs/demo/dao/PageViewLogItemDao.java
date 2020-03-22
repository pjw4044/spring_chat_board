package com.example.sbs.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.sbs.demo.dto.PageViewLogItem;

@Mapper
public interface PageViewLogItemDao {

	public void addLog(PageViewLogItem pageViewLogItem);

}
