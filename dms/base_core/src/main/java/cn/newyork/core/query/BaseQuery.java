package cn.newyork.core.query;

public class BaseQuery {
    /**
     * page:当前页
     * rows:每页显示条数
     * q:高级查询传入参数
     */
    //
    private int page = 1;
    private int rows = 10;
    private String q;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * 从那一页开始显示数据
     * @return 显示数据的页
     */
    public int getStart(){
        return (this.page-1)*rows;
    }
}
