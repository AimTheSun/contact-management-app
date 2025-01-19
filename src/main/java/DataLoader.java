import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class DataLoader {

    public static void main(String[] args) {
        SpringApplication.run(DataLoader.class, args);
    }

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            String url = "jdbc:mysql://localhost:3306/contact_manager";
            String user = "root";
            String password = "vagos123";

            String[] firstNames = {"John", "Jane", "Michael", "Sarah", "David", "Emily", "Chris", "Jessica"};
            String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis"};

            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String sql = "INSERT INTO contacts (first_name, last_name, zip_code, date_of_birth) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                Random random = new Random();
                for (int i = 0; i < 10000; i++) {
                    String firstName = firstNames[random.nextInt(firstNames.length)];
                    String lastName = lastNames[random.nextInt(lastNames.length)];
                    String zipCode = String.format("%05d", random.nextInt(9999));
                    LocalDate dateOfBirth = LocalDate.of(
                            1950 + random.nextInt(60), // Ano entre 1950 e 2010
                            1 + random.nextInt(12),    // Mês entre 1 e 12
                            1 + random.nextInt(28)     // Dia entre 1 e 28
                    );

                    preparedStatement.setString(1, firstName);
                    preparedStatement.setString(2, lastName);
                    preparedStatement.setString(3, zipCode);
                    preparedStatement.setDate(4, java.sql.Date.valueOf(dateOfBirth));

                    preparedStatement.addBatch();

                    if (i % 1000 == 0) { // Executar em lotes de 1000
                        preparedStatement.executeBatch();
                        System.out.println("Inseridos " + i + " registros até agora...");
                    }
                }

                preparedStatement.executeBatch(); // Lote final
                System.out.println("Carregamento de dados concluído!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
