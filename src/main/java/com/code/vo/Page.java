/*
 * TOP SECRET Copyright 2006-2015 Transsion.com All right reserved. This software is the confidential and proprietary
 * information of Transsion.com ("Confidential Information"). You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement you entered into with Transsion.com.
 */
package com.code.vo;

/**
 * ClassName:Page <br/>
 * Date: 2018年10月22日 下午3:07:24 <br/>
 * 
 * @author fenglibin1982@163.com
 * @Blog http://blog.csdn.net/fenglibing
 * @version
 * @see
 */
public class Page<T> {

    /**
     * current request page
     */
    private int currentPage = 1;
    /**
     * current request page size
     */
    private int pageSize = 10;
    /**
     * the start offset of the request record, this needed to be calculate by the page and rows
     */
    private int offset = 0;
    /**
     * total pages of this request
     */
    private int totalPages = 0;
    /**
     * total records of this records
     */
    private int totalCount = 0;
    /**
     * thd search request obj which used for where condition
     */
    private T   obj;
    
    public Page() {
        
    }
    
    public Page(Page<?> page) {
        this.currentPage = page.currentPage;
        this.offset = page.getOffset();
        this.pageSize = page.getPageSize();
        this.totalCount = page.getTotalCount();
        this.totalPages = page.getTotalPages();
    }
    
    public Page(Page<?> page, T t) {
        this.currentPage = page.currentPage;
        this.offset = page.getOffset();
        this.pageSize = page.getPageSize();
        this.totalCount = page.getTotalCount();
        this.totalPages = page.getTotalPages();
        this.obj = t;
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

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 根据总记录数、当前页及每页的大小，计算倒序显示记录的数据的偏移量，这样可以解决通过order by倒序显示数据增加数据库负担的问题<br>
     * 如满足要求的记录总数有405条，每页显示10条，则第一页取的数据就是从第396条开始取取到第406条数据，第二页从386条取到395条，其它依次类推。
     * @param totalCount
     * @return 计算好的page结果
     */
    public Page<T> reverseDisplayCalculate(int totalCount) {
        if (totalCount == 0) {
            return this;
        }
        this.totalCount = totalCount;
        /**
         * Calculate total pages
         */
        int mod = totalCount % pageSize;
        totalPages = totalCount / pageSize;
        if (mod > 0) {
            totalPages++;
        }

        if (currentPage > totalPages) {// 如果当前页面大于了总页数，是查不出来数据的，如这里用户输入页码为4时，是不会有结果的，直接返回0记录
            offset = 0;
            pageSize = 0;
            totalPages = 0;
            totalCount = 0;
            return this;
        }

        offset = totalCount - currentPage * pageSize;
        if (offset < 0) {
            offset = 0;
        }

        if (offset == 0) {
            pageSize = totalCount - ((currentPage - 1) * pageSize);
        }
        return this;
    }
    
    /**
     * 根据总记录数、当前页及每页的大小，按查询到的结果得到顺序分页显示结果
     * @param totalCount
     * @return
     */
    public Page<T> sequentialDisplayCalculate(int totalCount) {
        if (totalCount == 0) {
            return this;
        }
        this.totalCount = totalCount;
        /**
         * Calculate total pages
         */
        int mod = totalCount % pageSize;
        totalPages = totalCount / pageSize;
        if (mod > 0) {
            totalPages++;
        }

        if (currentPage > totalPages) {// 如果当前页面大于了总页数，是查不出来数据的，如这里用户输入页码为4时，是不会有结果的，直接返回0记录
            offset = 0;
            pageSize = 0;
            totalPages = 0;
            totalCount = 0;
            return this;
        }

        offset = (currentPage - 1) * pageSize;
        return this;
    }
}
