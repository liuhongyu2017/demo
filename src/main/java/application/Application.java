package application;

import cn.hutool.core.util.ReUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0.0 2022/11/13
 */
public class Application {

  public static void main(String[] args) throws Exception {
    List<Entity> all = Db.use()
        .findAll(Entity.create("ent_business_information_food_production").set("id", "> 10000"));
    all.forEach(item -> {
      Long id = item.getLong("id");
      Long pid = item.getLong("pid");
      String content = item.getStr("content");

      List<String> resultFindAll = ReUtil.findAll("[1-9.]{2}[\\u4e00-\\u9fa5 ：， 、% （ ）]+", content, 0,
          new ArrayList<>());
      System.out.println(id);
      System.out.println(content);
      System.out.println(JSONUtil.toJsonStr(resultFindAll));
    });
  }
}
