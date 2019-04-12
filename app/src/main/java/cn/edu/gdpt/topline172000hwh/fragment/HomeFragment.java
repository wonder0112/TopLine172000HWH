package cn.edu.gdpt.topline172000hwh.fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

import cn.edu.gdpt.topline172000hwh.R;
import cn.edu.gdpt.topline172000hwh.bean.NewsBean;
import cn.edu.gdpt.topline172000hwh.utils.Constant;
import cn.edu.gdpt.topline172000hwh.utils.JsonParse;

public class HomeFragment extends Fragment {
    private OkHttpClient okHttpClient;
    private MHandle mHandle;
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        okHttpClient=new OkHttpClient();
        mHandle=new MHandle();
        getADData();//P91
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    //P94
    private void getADData() {
        Request request=new Request.Builder().url(Constant.WEB_SITE+Constant.REQUEST_AD_URL).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
            }
            @Override
            public void onResponse(Response response) throws IOException {
                String res=response.body().string();
                //Log.i("AD",res);
                Message msg=new Message();
                msg.what=1;
                msg.obj=res;
                mHandle.sendMessage(msg);
            }
        });
    }
    //Handle  P93
    class MHandle extends Handler{
        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);
            switch (msg.what){
                case 1:
                   String adResult=(String) msg.obj;
                   Toast.makeText(getContext(),adResult,Toast.LENGTH_LONG).show();
                   List<NewsBean> adl= JsonParse.getInstance().getAdList(adResult);
            }
        }
    }
}
