package com.wzp.mouth.eat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wzp.mouth.eat.dao.Lottery;
import com.wzp.mouth.eat.dao.Message;
import com.wzp.mouth.eat.dao.Restaurantname;
import com.wzp.mouth.eat.mapper.LotteryMapper;
import com.wzp.mouth.eat.service.MessageService;
import com.wzp.mouth.eat.util.HttpClientUtils;
import com.wzp.mouth.eat.util.RestResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EatApplicationTests {

	@Autowired
	LotteryMapper lotteryMapper;

    @Autowired
    MessageService messageService;

	@Test
	public void test() throws Exception {
		RestResult restResult = HttpClientUtils.get(
			"https://webapi.sporttery.cn/gateway/lottery/getHistoryPageListV1.qry?gameNo=85&provinceId=0&pageSize=2100&isVerify=1&pageNo=1",
			null);
		String message = restResult.getMessage();
		JSONObject parse = JSON.parseObject(message);
		JSONObject value = (JSONObject)parse.get("value");
		JSONArray list = value.getJSONArray("list");
		for (Object obj:list){
			JSONObject hh = (JSONObject)obj;
			String id = (String)hh.get("lotteryDrawNum");
			String number = (String)hh.get("lotteryDrawResult");
			String date = (String)hh.get("lotteryDrawTime");
			lotteryMapper.insert(Integer.parseInt(id),date,number);
		}
		System.out.println(message);
	}


	@Test
	public void test100000(){
//		List<Lottery> select = lotteryMapper.select();
//		for (int i = 0;i<1;i++) {
//			select(select);
//		}
        StringBuilder sb = new StringBuilder();
        sb.append(DateFormatUtils.format(Long.parseLong("1615542185"), "yyyy-MM-dd HH:mm:ss")).
            append(": ").append("message.getMessage()").append("\n");
//        DateFormatUtils.format(Long.parseLong("1615542185"), "yyyy-MM-dd HH:mm:ss");
        System.out.println(sb);
	}



	@Test
	public void select(List<Lottery> select){
		long start = System.currentTimeMillis();
		HashMap<Integer,Integer> qianmap = new HashMap<>();
		HashMap<Integer,Integer> houmap = new HashMap<>();

		//1.取多少为一组 x ，统计出每个数字的个数n，然后用x+1-n，然后进行抽签，抽签的结果跟x+1的number比对，中奖结果
		//2.抽签
		int n = 1000;
		for (int i = 0 ;i < 1000;i++){
			qianmap.clear();
			houmap.clear();
			for (int j = i; j < n+i; j++) {
				Lottery lottery = select.get(j);
				String number = lottery.getNumber();
				String[] s = number.split(" ");
				//前区
				for(int k = 0 ;k < 5 ;k++){
					Integer old = qianmap.get(Integer.parseInt(s[k]));
					if (old != null) {
						qianmap.put(Integer.parseInt(s[k]),++old);
					}else{
						qianmap.put(Integer.parseInt(s[k]),1);
					}
				}

				for(int k = 5 ;k < 7 ;k++){
					Integer old = houmap.get(Integer.parseInt(s[k]));
					if (old != null) {
						houmap.put(Integer.parseInt(s[k]),++old);
					}else{
						houmap.put(Integer.parseInt(s[k]),1);
					}
				}
			}


			//qian
			List<Integer> qianpool = new ArrayList<>();
			for (int t = 1 ; t <= 35 ; t++) {
				Integer num = qianmap.get(t);
				int all = n;
				if (num != null) {
					all = all - num;
				}
				for (int q = 0 ;q < all;q++){
					qianpool.add(t);
				}
			}

			//qian
			List<Integer> houpool = new ArrayList<>();
			for (int t = 1 ; t <= 12 ; t++) {
				Integer num = houmap.get(t);
				int all = n;
				if (num != null) {
					all = all - num;
				}
				for (int q = 0 ;q < all;q++){
					houpool.add(t);
				}
			}

			List<Integer> qianzhongjiangchi = new ArrayList<>();
			List<Integer> houzhongjiangchi = new ArrayList<>();
			//从前池抽5个 后池抽2个
			Random random = new Random();
			Collections.shuffle(qianpool);
			Integer qianfirst = qianpool.get(random.nextInt(qianpool.size()));
			delete(qianpool,qianfirst);
			Collections.shuffle(qianpool);
			Integer qiansecond = qianpool.get(random.nextInt(qianpool.size()));
			delete(qianpool,qiansecond);
			Collections.shuffle(qianpool);
			Integer qianthird = qianpool.get(random.nextInt(qianpool.size()));
			delete(qianpool,qianthird);
			Collections.shuffle(qianpool);
			Integer qianfourth= qianpool.get(random.nextInt(qianpool.size()));
			delete(qianpool,qianfourth);
			Collections.shuffle(qianpool);
			Integer qianfifth = qianpool.get(random.nextInt(qianpool.size()));
			delete(qianpool,qianfifth);
			qianzhongjiangchi.add(qianfirst);
			qianzhongjiangchi.add(qiansecond);
			qianzhongjiangchi.add(qianthird);
			qianzhongjiangchi.add(qianfourth);
			qianzhongjiangchi.add(qianfifth);

			Collections.shuffle(houpool);
			Integer houfirst = houpool.get(random.nextInt(houpool.size()));
			delete(houpool,houfirst);
			Collections.shuffle(houpool);
			Integer housecond = houpool.get(random.nextInt(houpool.size()));
			delete(houpool,housecond);
			houzhongjiangchi.add(houfirst);
			houzhongjiangchi.add(housecond);
			System.out.println("抽出号码："+qianfirst+" "+qiansecond+" "+qianthird+" "+qianfourth+" "+qianfifth+" "+houfirst+" "+housecond);

			System.out.println("中奖号码："+select.get(n + i).getNumber());
			String[] really = select.get(n + i).getNumber().split(" ");
			int qianzhongjiangnum = 0;
			int houzhongjiangnum= 0;
			for (int r = 0;r < 5;r++) {
				if (qianzhongjiangchi.contains(Integer.parseInt(really[r]))){
					qianzhongjiangnum++;
				}
			}
			for (int r = 5;r < 7;r++) {
				if (houzhongjiangchi.contains(Integer.parseInt(really[r]))){
					houzhongjiangnum++;
				}
			}
			zhongjiang(qianzhongjiangnum,houzhongjiangnum);
		}
		System.out.println("一等奖："+ yidengjiang+"二等奖："+ erdengjiang+"三等奖："+sandengjiang+"四等奖："+sidengjiang+"五等奖："+wudengjiang+"六等奖："+liudengjiang+"七等奖："+qidengjiang+"八等奖："+badengjiang+"九等奖："+jiudengjiang);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}


	public void delete(List<Integer> list,Integer i){
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()){
			Integer next = iterator.next();
			if (next.equals(i)) {
				iterator.remove();
			}
		}
	}

	public Integer yidengjiang = 0;
	public Integer erdengjiang = 0;
	public Integer sandengjiang = 0;
	public Integer sidengjiang = 0;
	public Integer wudengjiang = 0;
	public Integer liudengjiang = 0;
	public Integer qidengjiang = 0;
	public Integer badengjiang = 0;
	public Integer jiudengjiang = 0;


	public void zhongjiang(Integer qianzhongjiangnum,Integer houzhongjiangnum){
		if (qianzhongjiangnum.equals(5) && houzhongjiangnum.equals(2)){
			yidengjiang++;
			System.out.println("一等奖");
		}
		if (qianzhongjiangnum.equals(5) && houzhongjiangnum.equals(1)){
			erdengjiang++;
			System.out.println("二等奖");
		}
		if (qianzhongjiangnum.equals(5) && houzhongjiangnum.equals(0)){
			sandengjiang++;
			System.out.println("三等奖");
		}
		if (qianzhongjiangnum.equals(4) && houzhongjiangnum.equals(2)){
			sidengjiang++;
			System.out.println("四等奖");
		}
		if (qianzhongjiangnum.equals(4) && houzhongjiangnum.equals(1)){
			wudengjiang++;
			System.out.println("五等奖");
		}
		if (qianzhongjiangnum.equals(3) && houzhongjiangnum.equals(2)){
			liudengjiang++;
			System.out.println("六等奖");
		}
		if (qianzhongjiangnum.equals(4) && houzhongjiangnum.equals(0)){
			qidengjiang++;
			System.out.println("七等奖");
		}
		if ((qianzhongjiangnum.equals(3) && houzhongjiangnum.equals(1)) || (qianzhongjiangnum.equals(2) && houzhongjiangnum.equals(2))){
			badengjiang++;
			System.out.println("八等奖");
		}
		if ((qianzhongjiangnum.equals(3) && houzhongjiangnum.equals(0)) || (qianzhongjiangnum.equals(2) && houzhongjiangnum.equals(1)) || (qianzhongjiangnum.equals(1) && houzhongjiangnum.equals(2)) || (qianzhongjiangnum.equals(0) && houzhongjiangnum.equals(2))){
			jiudengjiang++;
			System.out.println("九等奖");
		}

	}


	@Test
	public void testmes(){
        String latitude = "30.337829";  //纬度
        String longitude = "120.118716";  //经度
        String label = "浙江省杭州市余杭区祥园路99号";  //地理位置精度

        List<Message> messages = messageService.selectMessage(latitude.substring(0,4), longitude.substring(0,4), label);

        StringBuilder sb = new StringBuilder();
        if (messages == null || messages.isEmpty()) {
            sb.append("地理位置：").append(label).append(",暂无留言。\n");
        }else {
            for (Message message: messages) {
                sb.append(DateFormatUtils.format(Long.parseLong(message.getCreateTime()), "yyyy-MM-dd HH:mm:ss")).
                    append(": ").append(message.getMessage()).append("\n");
            }
        }
        sb.append("留言请先发送+1，然后再发送留言内容。");
    }

}
