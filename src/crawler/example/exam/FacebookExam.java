package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.7"
				+ "/crazyck101/posts?fields=id,link,message,created_time,reactions.type(LOVE).limit(0).summary(total_count)&since=1480849200&until=1480856400"
				+ "&access_token=EAACEdEose0cBAPFl8xZARKAktZC6jS74r63UnLEn3b6mrE3dNHbiwEPuWt5ymU3hRIdhKRsSz1mYR2sJuZAL6nZByBaFPsH4L7zcs59EhyI9WfQJJ7DnGKQ6n3y3p0l480WmcntPoFbJzSd6ZAdsZCwU9LVrSzYwIPfERVp0tr3wZDZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,reactions\n";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();

			// FIXIT
			String reactions = data.select("reactions").text();;


			output += id + "," + reactions + "\n";
		}

		System.out.println( output );
	} 
}
