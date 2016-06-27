package com.weixinninegridlayout;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private ListView listView;
    private List<List<Image>> imagesList;

    private String[][] images=new String[][]{{
             "http://img4.duitang.com/uploads/item/201209/25/20120925201555_eUHEU.jpeg","640","960"}
            ,{"http://7xvjnq.com1.z0.glb.clouddn.com/16-6-27/59949568.jpg","250","250"}
            ,{"http://7xvjnq.com1.z0.glb.clouddn.com/16-6-27/94999859.jpg","250","250"}
            ,{"http://7xvjnq.com1.z0.glb.clouddn.com/16-6-27/75918629.jpg","250","250"}
            ,{"http://7xvjnq.com1.z0.glb.clouddn.com/16-6-27/81091304.jpg","250","250"}
            ,{"http://7xvjnq.com1.z0.glb.clouddn.com/16-6-27/15664832.jpg","250","250"}
            ,{"http://7xvjnq.com1.z0.glb.clouddn.com/16-6-27/40210492.jpg","250","250"}
            ,{"http://7xvjnq.com1.z0.glb.clouddn.com/16-6-27/77762822.jpg","250","250"}
            ,{"http://img3.douban.com/view/photo/raw/public/p1708880537.jpg","1280","800"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.lv_main);
        initData();
        listView.setAdapter(new MainAdapter(MainActivity.this,imagesList));

    }

    private void initData() {
        imagesList=new ArrayList<>();
       //这里单独添加一条单条的测试数据，用来测试单张的时候横竖图片的效果
        ArrayList<Image> singleList=new ArrayList<>();
        singleList.add(new Image(images[8][0],Integer.parseInt(images[8][1]),Integer.parseInt(images[8][2])));
        imagesList.add(singleList);
        //从一到9生成9条朋友圈内容，分别是1~9张图片
        for(int i=0;i<9;i++){
            ArrayList<Image> itemList=new ArrayList<>();
             for(int j=0;j<=i;j++){
                 itemList.add(new Image(images[j][0],Integer.parseInt(images[j][1]),Integer.parseInt(images[j][2])));
             }
            imagesList.add(itemList);
        }
    }

}
