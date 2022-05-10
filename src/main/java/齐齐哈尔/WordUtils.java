package 齐齐哈尔;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import cn.afterturn.easypoi.entity.ImageEntity;
import cn.afterturn.easypoi.word.entity.MyXWPFDocument;
import cn.afterturn.easypoi.word.parse.excel.ExcelMapParse;
import cn.hutool.core.util.StrUtil;

/**
 * word转换工具
 *
 * @author lhy
 * @version 1.0 2021/12/21
 */
public class WordUtils {

  /**
   * 替换文本
   *
   * @param tag 标为文本
   * @param content 替换文本
   */
  public static byte[] replace(InputStream docTemplate, String tag, String content) {
    try (MyXWPFDocument doc = new MyXWPFDocument(docTemplate)) {
      Map<String, Object> params = new HashMap<>();
      params.put(tag, content);
      paragraphs(doc.getParagraphs(), params);
      Iterator<XWPFTable> itTable = doc.getTablesIterator();
      while (itTable.hasNext()) {
        XWPFTable table = itTable.next();
        List<XWPFTableRow> rows = table.getRows();
        for (XWPFTableRow row : rows) {
          List<XWPFTableCell> tableCells = row.getTableCells();
          for (XWPFTableCell tableCell : tableCells) {
            paragraphs(tableCell.getParagraphs(), params);
          }
        }
      }
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      doc.write(bos);
      return bos.toByteArray();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private static void paragraphs(List<XWPFParagraph> paragraphs, Map<String, Object> param) {
    for (XWPFParagraph paragraph : paragraphs) {
      String content = paragraph.getText();
      List<String> tags = new ArrayList<>();
      boolean label = true;
      for (String key : param.keySet()) {
        if (StringUtils.contains(content, key)) {
          tags.add(key);
        }
      }
      for (int i = 0; i < paragraph.getRuns().size(); i++) {
        XWPFRun run = paragraph.getRuns().get(i);
        String text = run.getText(0);

        for (String tag : tags) {
          // 对图片进行单独处理
          if (StringUtils.contains(tag, "code")) {
            Object code = param.get("code");
            if (label) {
              if (code instanceof ImageEntity) {
                run.setText("", 0);
                ExcelMapParse.addAnImage((ImageEntity) code, run);
              }
              label = false;
            } else {
              run.setText("", 0);
            }
          } else {
            if (StringUtils.contains(tag, text) || StringUtils.contains(text, tag)) {
              text = StrUtil.toString(param.get(tag));
              if (label) {
                run.setText(text, 0);
                label = false;
              } else {
                run.setText("", 0);
              }
            }
          }
        }
      }
    }
  }
}
