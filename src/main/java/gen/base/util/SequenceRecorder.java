package gen.base.util;

import java.util.ArrayList;
import java.util.List;

public class SequenceRecorder {
    //分隔符
    private String separator;
    //有序索引列表
    private List<String> indexList;
    //当前索引
    private Integer recordIndexNow;
    //当前值
    private String recordValueNow;

    public SequenceRecorder(){
        this.indexList = new ArrayList<>();
        this.recordIndexNow = 0;
        this.separator = "|=@##@=|";
    }
    //添加记录
    public void addRecord(String name, String prefix){
        this.indexList.add(prefix + this.separator +name);
    }
    //重新头查看记录初始化
    public void startGet(){
        this.recordIndexNow = 0;
    }
    //判断是否遍历完
    public boolean hasNext(){
        boolean bool = this.recordIndexNow < this.indexList.size();
        if(bool) this.next();
        return bool;
    }
    //指针移动
    private void next(){
        this.recordValueNow = this.indexList.get(this.recordIndexNow);
        this.recordIndexNow++;
    }
    public String getPrefix(){
        Integer separtorIndex = this.recordValueNow.indexOf(this.separator);
        System.out.println(this.recordValueNow.substring(0,separtorIndex));
        return this.recordValueNow.substring(0,separtorIndex);
    }
    public String getIndex(){
        Integer separtorLastIndex = this.recordValueNow.indexOf(this.separator) + this.separator.length();
        System.out.println(this.recordValueNow.substring(separtorLastIndex));
        return this.recordValueNow.substring(separtorLastIndex);
    }
}
