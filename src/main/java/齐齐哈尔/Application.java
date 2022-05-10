package 齐齐哈尔;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * @author lhy
 * @version 1.0.0 2021/9/6
 */
public class Application {

  private static final String wordToPdf = "http://1.117.80.158:8203/client/convert_docx_to_pdf";

  public static void main(String[] args) throws IOException, SQLException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    List<Entity> query = Db.use().query("select * from error_date");
    query.parallelStream().forEach(item -> {
      Long id = item.getLong("id");
      String report = item.getStr("report");
      try {
        String data =
            data(item.getStr("files"), simpleDateFormat.format(item.getDate("create_time")));
        System.out.println("id: " + id);
        System.out.println("url: " + data);
        if (StringUtils.isNotBlank(data)) {
          JSONObject jsonObject = JSONUtil.parseObj(report);
          String name = jsonObject.getStr("name");
          JSONObject obj = JSONUtil.createObj();
          obj.putOpt("name", name);
          obj.putOpt("url", data);
          Db.use().update(Entity.create().set("report", obj.toString()),
              Entity.create("error_date").set("id", id));
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  public static String data(String docx, String time) throws Exception {
    if (StrUtil.isBlank(docx)) {
      return "";
    }
    byte[] bDocx = HttpUtil.downloadBytes(JSONUtil.parseObj(docx).getStr("url"));
    InputStream in = new ByteArrayInputStream(bDocx);
    HttpResponse response = HttpUtil.createPost(wordToPdf)
        .form("file", WordUtils.replace(in, "出仓时间：", "出仓时间：" + time), "").execute();
    return MinioUtils.uploadFile(response.bodyBytes());
  }
}
