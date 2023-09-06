package br.com.renner.toolbox;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryFormatter {

    public static JSONArray parseResultsetToJsonArray(ResultSet resultSet) throws SQLException {
        JSONArray jsonArray = new JSONArray();

        while (resultSet.next()) {

            int columns = resultSet.getMetaData().getColumnCount();
            JSONObject obj = new JSONObject();

            for (int i = 0; i < columns; i++)
                obj.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(), resultSet.getObject(i + 1));

            jsonArray.put(obj);
        }
        return jsonArray;
    }
}
