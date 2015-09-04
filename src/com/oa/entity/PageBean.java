package com.oa.entity;

import java.util.List;

public class PageBean {
	private int currentPage; // 当前页
	private int pageSize; // 每页显示多少

	private int recordCount; // 总记录数
	private List recordList; // 记录列表

	private int pageCount; // 总页数
	private int beginPageIndex; // 开始索引
	private int endPageIndex; // 结束索引
	public PageBean(){}
	
	
	public PageBean(int currentPage, int pageSize, int recordCount,List recordList) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.recordList = recordList;
		this.pageCount = (recordCount+pageSize-1)/pageSize;
		if(pageCount<=10){
			this.beginPageIndex = 1;
			this.endPageIndex = pageCount ;
		}else{
			this.beginPageIndex = currentPage-4;
			this.endPageIndex = currentPage+5;
			if(beginPageIndex<=1){
				this.beginPageIndex = 1;
				this.endPageIndex = 10;
				
			}
			if(endPageIndex>=pageCount){
				this.beginPageIndex = pageCount-10;
				this.endPageIndex = pageCount;
				
			}
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List getRecordList() {
		return recordList;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

}
