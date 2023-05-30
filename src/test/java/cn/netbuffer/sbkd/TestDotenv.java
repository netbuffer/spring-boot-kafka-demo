package cn.netbuffer.sbkd;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TestDotenv {

    @Test
    public void testReadEnv() {
        String project = System.getProperty("user.dir");
        String envPath = project;
        Dotenv dotenv = Dotenv.configure()
                .directory(envPath)
                .filename("sbkd.env")
                .load();
        log.debug("read KAFKA_ADVERTISED_HOST_NAME={} from env file[{}]", dotenv.get("KAFKA_ADVERTISED_HOST_NAME"), envPath);
    }

}
