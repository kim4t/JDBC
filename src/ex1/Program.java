package ex1;

import com.app.console.PostConsole;
import com.app.entity.Post;
import com.app.service.PostService;

import java.sql.*;

public class Program {
    public static void main(String[] args) throws SQLException {
        PostConsole postConsole = new PostConsole();

        postConsole.printDashBoard();
    }
}
