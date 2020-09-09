package com.example.ex015;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Solving extends AppCompatActivity {

    WebView graph;
    Double a,b,c,part,an1,an2;
    int mainPage;
    TextView ans1,ans2;
    Intent solved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solving);

        graph=(WebView) findViewById(R.id.graph);
        ans1=(TextView) findViewById(R.id.ans1);
        ans2=(TextView) findViewById(R.id.ans2);

        mainPage=1;

        graph.getSettings().setJavaScriptEnabled(true);
        graph.setWebViewClient(new MyWebViewClient());

        showGraph();
        math();
    }

    private void math() {
        part=(b*b)-4*a*c;
        an1=(-b-(Math.sqrt(part)))/2*a;
        an2=(-b+(Math.sqrt(part)))/2*a;
        if((part)<0) {
            ans1.setText("there is no answer");
            ans2.setText("there is no answer");
        }
        else {
            ans1.setText("x1= "+ (an1));
            ans2.setText("x2= "+ (an2));
        }
    }

    public void showGraph(){
        solved= getIntent();
        a= solved.getDoubleExtra("para",mainPage);
        b= solved.getDoubleExtra("parb",mainPage);
        c=solved.getDoubleExtra("parc",mainPage);
        String sa=a.toString();
        String sb=b.toString();
        String sc=c.toString();
        a = Double.parseDouble(sa);
        b = Double.parseDouble(sb);
        c = Double.parseDouble(sc);
        if (a > 0)
            if (c > 0)
                graph.loadUrl("https://www.google.com/search?sxsrf=ALeKk02ib-jVvetky8xNaUimiLZdsY3P0g%3A1587972763862&ei=m4qmXtSONMOVkwWk87mQDQ&q=" + a + "*x%5E2%2B" + b + "*x%2B" + c + "&oq=" + a + "*x%5E2%2B" + b + "*x%2B" + c + "&gs_lcp=CgZwc3ktYWIQAzoECCMQJzoGCAAQBxAeOgcIIxDqAhAnOgQIABBDOgIIADoFCAAQgwE6BAgAEB46BggAEAgQHlDDE1ijvAFg1cEBaAJwAHgAgAHFAogB1xmSAQgwLjE1LjMuMZgBAKABAaoBB2d3cy13aXqwAQo&sclient=psy-ab&ved=0ahUKEwiUyILEi4jpAhXDyqQKHaR5DtIQ4dUDCAw&uact=5");
            else
                graph.loadUrl("https://www.google.com/search?sxsrf=ALeKk02WW9HC-sasb3XTpiH3OpL1CTT79A:1587903014796&q=" + a + "*x%5E2%2B" + b + "x" + c + "&spell=1&sa=X&ved=2ahUKEwj8v4nZh4bpAhUTuHEKHdKLDnYQBSgAegQIBxAq&biw=1280&bih=578");
        else if (c > 0)
            graph.loadUrl("https://www.google.com/search?sxsrf=ALeKk0069_JmTOT7-bp_Wb8YPO1AvzKRHQ%3A1587972789496&ei=tYqmXsDhHZC8kwXvmqagCw&q=" + a + "*x%5E2%2B" + b + "*x%2B" + c + "&oq=" + a + "*x%5E2%2B" + b + "*x%2B" + c + "&gs_lcp=CgZwc3ktYWIQAzoHCCMQ6gIQJ1C_rskBWKfkygFgk-bKAWgBcAB4AYABpgKIAbcEkgEDMi0ymAEMoAEBqgEHZ3dzLXdperABCg&sclient=psy-ab&ved=0ahUKEwiAkJ_Qi4jpAhUQ3qQKHW-NCbQQ4dUDCAw&uact=5");
        else
            graph.loadUrl("https://www.google.com/search?sxsrf=ALeKk023TCnPMU0DWP3yMJww32TBeo9PYg%3A1587829239789&ei=91mkXrXZL8ODsAeu-bLoDQ&q=" + a + "*x%5E2%2B" + b + "*x" + c + "&oq=-2*x%5E2%2B4*x-16&gs_lcp=CgZwc3ktYWIQAzoHCCMQ6gIQJzoCCABQ0cUEWN6nBWD2sAVoAXAAeACAAaIBiAHQD5IBBDAuMTSYAQCgAQGqAQdnd3Mtd2l6sAEK&sclient=psy-ab&ved=0ahUKEwj1sLTu9IPpAhXDAewKHa68DN0Q4dUDCAw&uact=5");
    }
    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public void back(View view) {
        solved.putExtra("answer1",an1);
        solved.putExtra("answer2",an2);
        setResult(RESULT_OK,solved);
        finish();
    }
}