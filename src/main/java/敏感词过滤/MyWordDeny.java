package 敏感词过滤;

import com.github.houbb.sensitive.word.api.IWordDeny;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @version 1.0.0 2022/2/17
 */
public class MyWordDeny implements IWordDeny {

  @Override
  public List<String> deny() {
    List<String> result = new ArrayList<>();
    result.add("毛主席");
    return result;
  }
}
