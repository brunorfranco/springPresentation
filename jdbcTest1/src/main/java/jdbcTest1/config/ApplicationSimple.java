package jdbcTest1.config;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jdbcTest1.model.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ApplicationSimple {

	private static final Logger log = LoggerFactory
			.getLogger(ApplicationSimple.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String args[]) {
		SpringApplication.run(ApplicationSimple.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {
				createTable();

				Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM customers", Integer.class);
				
				log.info("Counting number of customers:" + count);
				
				Map<String, Object> map = jdbcTemplate.queryForMap("SELECT * FROM customers where id = ?", 1);
				
				log.info("Getting customer where id = 1:" + map);
			}

			private void createTable() {
				log.info("Creating tables");

				jdbcTemplate
						.execute("CREATE TABLE customers("
								+ "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

				List<Object[]> splitUpNames = Arrays
						.asList("John Woo", "Jeff Dean", "Josh Bloch",
								"Josh Long").stream()
						.map(name -> name.split(" "))
						.collect(Collectors.toList());

				jdbcTemplate
						.batchUpdate(
								"INSERT INTO customers(first_name, last_name) VALUES (?,?)",
								splitUpNames);
			}
		};
	}

}
