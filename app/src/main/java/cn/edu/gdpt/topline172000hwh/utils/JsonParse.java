package cn.edu.gdpt.topline172000hwh.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import cn.edu.gdpt.topline172000hwh.bean.NewsBean;

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
    //P95
    public List<NewsBean> getAdList(String json){
        Gson gson=new Gson();
        Type listType=new TypeToken<List<NewsBean>>(){}.getType();
        List<NewsBean> alList=gson.fromJson(json,listType);
        return alList;
    }
}
