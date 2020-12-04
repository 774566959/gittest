package project.pojo;

import java.io.*;

/**
 * ��ҳʵ����
 * 
 * @author Ѷ���Ƽ�
 * @version 1.0 2020-11-11
 */
public class PageIndexer implements Serializable {
	private int pageIndex;// ҳ��
	private int pageSize;// ÿҳ����
	private int pageCount;// ��ҳ��

	public PageIndexer() {

	}

	public PageIndexer(int pageIndex, int pageSize, int pageCount) {
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
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
}
