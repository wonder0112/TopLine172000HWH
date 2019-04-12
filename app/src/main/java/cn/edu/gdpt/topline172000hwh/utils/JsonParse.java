package cn.edu.gdpt.topline172000hwh.utils;

public class JsonParse {//P68 单例模式 只有一个对象  对象由构造方法产生
    private static JsonParse instance;
    private JsonParse() {//构造方法私有化，类外部不能调用，拒绝创建对象。
    }
    public static JsonParse getInstance(){
        if (instance==null){
            instance=new JsonParse();
        }
        return instance;
    }
}
