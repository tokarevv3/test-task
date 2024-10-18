package database;

import util.ConnectionManager;
import java.sql.SQLException;

public class Table {

    private static final String CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS Employee (
            id INTEGER NOT NULL PRIMARY KEY,
            firstName VARCHAR(30),
            lastName VARCHAR(30),
            dateOfBirth TIMESTAMP,
            department VARCHAR(30),
            salary INTEGER);
            """;

    private static final String INSERT_VALUES = """
            INSERT INTO Employee(id, firstname, lastname, dateofbirth, department, salary) VALUES 
                                         (1, 'Ivan', 'Fadeev','03-03-2000', '1C', 15000),
                                         (2,'Andrew', 'Goroj', '22-12-1996', '1B', 12305),
                                         (3,'Alla', 'Mohnatova', '16-07-2006', '1A', 9500),
                                         (4,'Eugen', 'Fedotov', '09-01-2002', '1B', 12500),
                                         (5, 'Abba', 'Ohha', '06-06-2003', '1A', 14800),
                                         (6,'SonOf', 'Director', '23-09-2005', '1A', 255500),
                                         (7,'Orha', 'Gemma', '05-02-1992', '1C', 17850),
                                         (8,'Alex', 'Gutther', '30-11-1995', '1B', 15001),
                                         (9,'Victor', 'Bochka', '22-05-2001', '1C', 13000),
                                         (10, 'Alla', 'Pugacheva', '15-04-1949', '1A', 12),
                                         (11, 'Ivan', 'Klementev', '05-10-2003', '1C', 15403),
                                         (12, 'Ivan', 'Bobryanski', '14-07-2004', '1B', 11054);
            """;


    public static boolean createTable() {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(CREATE_TABLE)) {
            return prepareStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int insertValues() {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(INSERT_VALUES)) {
            return prepareStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
