import com.alibaba.druid.filter.config.ConfigTools;
import net.sf.json.JSONObject;
import utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/5/28 16:09
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) throws Exception {
        String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIWkJP4lJWGujrx4iqGD41WKDH/q9khJKv1Mfn" +
                "e6coRjH7azTxIYrZy0/80Riaup7WdhpT8vG2JJBkYV417YVlMCAwEAAQ==";



        String privateKey = "MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEAhaQk/iUlYa6OvHiKoYPjV" +
                "YoMf+r2SEkq/Ux+d7pyhGMftrNPEhitnLT/zRGJq6ntZ2GlPy8bYkkGRhXjXthWUwIDAQABAkALfRr5B" +
                "jR6e0kmBq7UR8RJXD7K2GYnvLKHaAYPQOYLX2JTIToxqp+pJiJCzgKTPUuowOmqEdU9Y7ZstcHLQo+RA" +
                "iEAucDHL+IGszZw+jnXapovPkUBfnrx+QRFTZ8peuS9aY8CIQC4LklNIX4m8H+p7bpgcVwzFc8AjbxNY" +
                "ya3ohlHQr68/QIhALcQ6/4f53SGChBCIzCXpknbXl6VspY1hEu8ufe5KYe3AiEAlmRlQnAY3J8A/7a4u" +
                "0uVZ7llICScH+zYjpX0YjXkHdkCIQCsytnqnCiohAEu0GZ71j/n0s501LodVpc1J1xY1S/ptg==";

//        String password = "PYzCR/smWhp/o5xSSo2AeNC+7vVYBlt02l5+LrIEec25e6x/akYOp7lgusoTxg6eJ/TSU+clGM5SFk3zZdYMPQ==";
        //String decrypt = ConfigTools.decrypt(publicKey, password);





        String encrypt = ConfigTools.encrypt(privateKey, "qwerASDF");
        String decrypt = ConfigTools.decrypt(publicKey, encrypt);

        //ConfigTools.
        System.out.println(decrypt);
        System.out.println(encrypt);
    }
}
