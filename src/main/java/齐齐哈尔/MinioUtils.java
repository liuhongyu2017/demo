package 齐齐哈尔;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import io.minio.MinioClient;
import io.minio.MinioClient.Builder;
import io.minio.PutObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;

/**
 * @author lhy
 * @version 1.0.0 2022/1/27
 */
public class MinioUtils {

  public static final String base = "https://ll.qqhrscjg.cn/qqhe-rapidx/data";

  public static MinioClient getMinioClient() {
    return new Builder().endpoint("http://221.209.84.89:8081").credentials("admin", "Tjzc@123")
        .build();
  }

  public static String uploadFile(byte[] data) {
    String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".pdf";
    try {
      getMinioClient()
          .putObject(PutObjectArgs.builder().bucket("qqhe-rapidx").object("data/" + fileName)
              .stream(new ByteArrayInputStream(data), -1, 5L * 1024 * 1024 * 1024).build());
    } catch (ErrorResponseException | InsufficientDataException | InternalException
        | InvalidKeyException | InvalidResponseException | IOException | NoSuchAlgorithmException
        | ServerException | XmlParserException e) {
      e.printStackTrace();
    }
    return base + "/" + fileName;
  }
}
