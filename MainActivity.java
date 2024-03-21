package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    String[]item={"型態1","型態2 (成就點數3點以上)","型態3 (成就點數5點以上)"};//型態選項
    int[] imgId={R.drawable.dog,R.drawable.dog1};//狗的圖片陣列
    int[] imgId2={R.drawable.kenting_1,R.drawable.kenting_2,R.drawable.kenting_3,R.drawable.yushan_1,R.drawable.yushan_2,R.drawable.yushan_3
            ,R.drawable.kinmen_1,R.drawable.kinmen_2,R.drawable.kinmen_3,R.drawable.sheipa_1,R.drawable.sheipa_2,R.drawable.sheipa_3
            ,R.drawable.taijiang_1,R.drawable.taijiang_2,R.drawable.taroko_1,R.drawable.taroko_2,R.drawable.taroko_3
            ,R.drawable.yangmingshan_1,R.drawable.yangmingshan_2,R.drawable.yangmingshan_3};
    private Button button1;
    ImageView activity_gif_giv;
    ImageView imageView5;//國家公園介紹圖
    TextView textView;//劇本
    TextView txtpoint;//成就點數
    InputStream streamCountLines;
    BufferedReader readerCountLines;
    InputStream inputStream;
    BufferedReader bufferedReader;
    int intCount=0;//計算文字行數
    int point=0;//點數
    int intCurrent;
    String[] textData;
    private TiaoZiUtil tiaoziUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity_gif_giv=(ImageView)findViewById(R.id.activity_gif_giv);
        textView=(TextView)findViewById(R.id.TextView);
        txtpoint=(TextView)findViewById(R.id.txtpoint);
        streamCountLines=this.getResources().openRawResource(R.raw.jokesdata);
        readerCountLines=new BufferedReader(new InputStreamReader(streamCountLines));
        imageView5=(ImageView)findViewById(R.id.imageView5);

        button1=findViewById(R.id.button1);//圖片型態
        button1.setOnClickListener(button1Listener);



        try {
            while(readerCountLines.readLine()!=null){
                intCount++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        inputStream=this.getResources().openRawResource(R.raw.jokesdata);
        bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        textData=new String[intCount];
        try {
            for (int i=0;i<intCount;i++){
                textData[i]=bufferedReader.readLine();
            }
        }catch (Exception f){
            f.printStackTrace();
        }
        textView.setText(textData[0]);
        intCount=0;
    }
    private Button.OnClickListener button1Listener=new Button.OnClickListener(){
        @Override

        public void onClick(View v) {

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("選擇型態")
                    .setIcon(R.mipmap.exit)
                    .setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(item[which]=="型態1"){
                                activity_gif_giv.setImageResource(R.drawable.dog);
                            }
                            else if(item[which]=="型態2 (成就點數3點以上)"&point>=3){
                                activity_gif_giv.setImageResource(R.drawable.dog1);
                            }
                            else if(item[which]=="型態3 (成就點數5點以上)"&point>=5){
                                activity_gif_giv.setImageResource(R.drawable.dog1);
                            }
                        }
                    })
                    .setPositiveButton("確定",new DialogInterface.OnClickListener(){
                        public  void onClick(DialogInterface dialog, int which){
                            dialog.dismiss();

                        }
                    })

                    .show();
        }
    };




    public void next(View v){//下一句
        if(intCount==textData.length-1){//最後一句顯示訊息
            Toast toast=Toast.makeText(MainActivity.this,"沒有下一句了", Toast.LENGTH_LONG);
            toast.show();
            point++;
            txtpoint.setText("成就點數："+point);
        }
        else
        { intCount++;
        tiaoziUtil = new TiaoZiUtil(textView, textData[intCount], 20);//文字逐字出現的效果
        if(intCount==25){imageView5.setImageResource(R.drawable.kenting_1);}
        else if(intCount==27){imageView5.setImageResource(R.drawable.kenting_2);}
        else if(intCount==30){imageView5.setImageResource(R.drawable.kenting_3);
        point++;txtpoint.setText("成就點數："+point);}

        else if(intCount==36){imageView5.setImageResource(R.drawable.yushan_1);}
        else if(intCount==39){imageView5.setImageResource(R.drawable.yushan_2);}
        else if(intCount==41){imageView5.setImageResource(R.drawable.yushan_3);
            point++;txtpoint.setText("成就點數："+point);}

        else if(intCount==47){imageView5.setImageResource(R.drawable.yangmingshan_1);}
        else if(intCount==50){imageView5.setImageResource(R.drawable.yangmingshan_2);}
        else if(intCount==54){imageView5.setImageResource(R.drawable.yangmingshan_3);
            point++;txtpoint.setText("成就點數："+point);}

        else if(intCount==60){imageView5.setImageResource(R.drawable.taroko_1);}
        else if(intCount==63){imageView5.setImageResource(R.drawable.taroko_2);}
        else if(intCount==67){imageView5.setImageResource(R.drawable.taroko_3);
            point++;txtpoint.setText("成就點數："+point);}

        else if(intCount==74){imageView5.setImageResource(R.drawable.sheipa_1);}
        else if(intCount==76){imageView5.setImageResource(R.drawable.sheipa_2);}
        else if(intCount==79){imageView5.setImageResource(R.drawable.sheipa_3);
            point++;txtpoint.setText("成就點數："+point);}

        else if(intCount==86){imageView5.setImageResource(R.drawable.kinmen_1);}
        else if(intCount==87){imageView5.setImageResource(R.drawable.kinmen_2);}
        else if(intCount==89){imageView5.setImageResource(R.drawable.kinmen_3);
            point++;txtpoint.setText("成就點數："+point);}

        else if(intCount==97){imageView5.setImageResource(R.drawable.taijiang_1);}
        else if(intCount==99){imageView5.setImageResource(R.drawable.taijiang_2);
            point++;txtpoint.setText("成就點數："+point);}


        }
    }
    public void previous(View v){//上一句
        if(intCount==0){//第一句顯示訊息
            Toast toast=Toast.makeText(MainActivity.this,"沒有上一句了", Toast.LENGTH_LONG);
            toast.show();
        }
        else
        intCount--;
        textView.setText(textData[intCount]);

    }
    public void first(View v){//twxtview指定為第一句
        intCount=0;
        textView.setText(textData[intCount]);

    }
    public void last(View v){//將twxtview指定為文本的最後一行
        intCount=textData.length-1;
        textView.setText(textData[intCount]);
        point++;
        txtpoint.setText("成就點數："+point);

    }

}
class TiaoZiUtil {//呼叫


    private static TextView tv;
    private static String s;
    private static int length;
    private static long time;
    static int n = 0;
    private static int nn;


    public TiaoZiUtil(TextView tv, String s, long time) {
        this.tv = tv;//textview
        this.s = s;//字串
        this.time = time;//間隔時間
        this.length = s.length();
        startTv(n);//開啟執行
    }


    public static void startTv(final int n) {

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            final String stv = s.substring(0, n);//擷取要填充的字串
                            tv.post(new Runnable() {
                                @Override
                                public void run() {
                                    tv.setText(stv);
                                }
                            });
                            Thread.sleep(time);//休息片刻
                            nn = n + 1;//n+1；多擷取一個
                            if (nn <= length) {//如果還有漢字，那麼繼續開啟執行緒，相當於遞迴的感覺
                                startTv(nn);
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }
                }

        ).start();


    }


}
