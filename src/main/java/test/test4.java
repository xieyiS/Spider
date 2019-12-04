package test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class test4 {
    public static void main(String[] args) {
        // 利用Jsoup获得连接
        Connection connect = Jsoup.connect("https://www.wukong.com/question/6586953004245582083/");
        try {
            // 得到Document对象
            Document document = connect.get();

            Elements elements = document.select(".question-name");
            System.out.println(elements.get(0).text());

            Elements elements2 = document.select(".answer-item");
            for(Element element : elements2)
            {
                Elements elements3  = element.select(".answer-user-avatar img");
                System.out.println(elements3.attr("abs:src"));

                elements3  = element.select(".answer-user-name");
                System.out.println(elements3.text());

                elements3  = element.select(".answer-user-tag");
                System.out.println(elements3.text());

                elements3  = element.select(".answer-text");
                System.out.println(elements3.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
