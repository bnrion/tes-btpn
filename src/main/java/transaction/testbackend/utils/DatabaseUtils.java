package transaction.testbackend.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DatabaseUtils {

    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=test_course;schema=dbo;encrypt=true;trustServerCertificate=true";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "yourStrong(!)Password";

    public static String callStoredProcedure(String procedureName, Object... params) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "{CALL " + procedureName + "(";
            if (params == null || params.length == 0) {
                query += ")}";
            } else {
                for (int i = 0; i < params.length; i++) {
                    query += "?,";
                }
                query = query.substring(0, query.length() - 1);
                query += ")}";
            }
            System.out.println(query);
            CallableStatement stmt = conn.prepareCall(query);
            for (int i = 0; i < params.length; i++) {
                if (params[i] == null) {
                    stmt.setNull(i + 1, Types.NULL);
                } else if (params[i] instanceof String) {
                    stmt.setString(i + 1, (String) params[i]);
                } else if (params[i] instanceof Integer) {
                    stmt.setInt(i + 1, (Integer) params[i]);
                } else if (params[i] instanceof Double) {
                    stmt.setDouble(i + 1, (Double) params[i]);
                } else if (params[i] instanceof Float) {
                    stmt.setFloat(i + 1, (Float) params[i]);
                } else if (params[i] instanceof Boolean) {
                    stmt.setBoolean(i + 1, (Boolean) params[i]);
                } // add more data types as needed
            }
            boolean hasResults = stmt.execute();
            while (hasResults) {
                ResultSet rs = stmt.getResultSet();
                ResultSetMetaData metaData = rs.getMetaData();
                int numColumns = metaData.getColumnCount();

                ObjectMapper objectMapper = new ObjectMapper();
                while (rs.next()) {
                    for (int i = 1; i <= numColumns; ++i) {
                        Object value = rs.getObject(i);
                        String jsonObject = objectMapper.convertValue(value,String.class);
                        return jsonObject;

                    }
                }
                hasResults = stmt.getMoreResults();
            }

//            String status = stmt.getString("status");
//            if (status.equals("success")) {
//                return stmt.getString("result");
//            } else {
//                String errorLine = stmt.getString("error_line");
//                String errorMsg = stmt.getString("_error_msg");
//                return "{status: failed, error_line: " + errorLine + ", _error_msg: " + errorMsg + "}";
//            }
            return "test";
        }
    }

}
