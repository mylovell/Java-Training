package com.lf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Reptile {

	public static void main(String[] args) throws Exception {
		
		Document doc = Jsoup.connect("https://ext.se.360.cn/webstore/category").get();
		// 找到节点共有的特征： class = appwrap。
		Elements apps = doc.select(".appwrap");
		
		apps.forEach((app) -> {
			int index = apps.indexOf(app);
			String img = app.selectFirst("img").attr("src");
			String name = app.selectFirst("h3").text();
			String intro = app.selectFirst(".intro").text();
			System.out.println(index + "、" + name + "_" + img + "_" + intro);
			
			// 发网络请求，下载图片到本地(Java很少发网络请求，一般都是等客户端发请求过来)
			new Thread(() ->  {
				try {
					HttpURLConnection conn = (HttpURLConnection) new URL(img).openConnection();
					conn.setRequestMethod("GET");
					conn.connect();
					try (
						InputStream is = conn.getInputStream();
						FileOutputStream fos = new FileOutputStream("/Users/fengluo/Desktop/123/imgs/" + name + ".jpg")	
					){
						byte[] buffer = new byte[8192];
						int len;
						while ((len = is.read(buffer)) != -1) {
							fos.write(buffer, 0, len);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();;
			
		});
	}

}
